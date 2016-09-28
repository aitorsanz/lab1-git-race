package es.unizar.webeng.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * This class configures the raw WebSocket used to keep track of the open sessions and inform
 * the clients of the number of active users at every moment.
 */
@Configuration
@EnableWebSocket
public class ClientCounter implements WebSocketConfigurer {

    @Autowired
    private CounterHandler counterHandler;  // The WebSocketHandler that manages the events related to the socket

    /**
     * Registers a handler for the ws://localhost:8080/ws WebSocket.
     * @param registry
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(counterHandler, "/ws");
    }

    /**
     * Class that updates a list with the active sessions whenever a new WebSocket connects or disconnects
     * and broadcasts the number of connected clients to the active ones.
     */
    @Component
    public class CounterHandler extends TextWebSocketHandler {

        private ConcurrentMap<String, WebSocketSession> activeSessions = new ConcurrentHashMap<>();

        /**
         * Executed after a client establishes a connection with the server.
         * @param session
         */
        @Override
        public void afterConnectionEstablished(WebSocketSession session) {
            activeSessions.put(session.getId(), session);
            try {
                for (WebSocketSession s : activeSessions.values()) {
                    s.sendMessage(new TextMessage("{\"value\": " + activeSessions.size() + "}"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * Executed after a client closes a connection with the server.
         * @param session
         * @param status
         */
        @Override
        public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
            activeSessions.remove(session.getId());
            try {
                for (WebSocketSession s : activeSessions.values()) {
                    s.sendMessage(new TextMessage("{\"value\": " + activeSessions.size() + "}"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
