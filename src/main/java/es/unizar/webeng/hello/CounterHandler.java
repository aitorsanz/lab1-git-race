package es.unizar.webeng.hello;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Class that updates a list with the active sessions whenever a new WebSocket connects or disconnects
 * and broadcasts the number of connected clients to the active ones.
 */
@Component
public class CounterHandler extends TextWebSocketHandler {

    private static final Logger logger = Logger.getLogger(CounterHandler.class);    // log4j logger

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
            logger.error(e.getMessage(), e);
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
            logger.error(e.getMessage(), e);
        }
    }
}
