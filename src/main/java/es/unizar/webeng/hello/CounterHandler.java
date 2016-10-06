package es.unizar.webeng.hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Class that updates a list with the active sessions whenever a new WebSocket connects or disconnects
 * and broadcasts the number of connected clients to the active ones.
 */
@Component
public class CounterHandler extends TextWebSocketHandler {

    /**
     * System's logger for exception notifying.
     */
    private static final Logger logger = LoggerFactory.getLogger(CounterHandler.class);

    /** Concurrent map that keeps opened WebSocketSessions.
     */
    private ConcurrentMap<String, WebSocketSession> activeSessions;

    /** ObjectMapper that converts HashMap to JSON (used in broadcastSessionCount() ).
     */
    @Autowired
    private ObjectMapper mapper;

    /**
     * This method initializes the class after doing the autowiring because of the
     * Java tag @PostConstruct.
     */
    @PostConstruct
    private void initialize() {
        activeSessions = new ConcurrentHashMap<>();
    }

    /**
     * This method sends a message to each open WebSocket with the number of active sessions.
     */
    private void broadcastSessionCount() {
        // Creates a map where to put the number of active clients
        Map<String, Integer> info = new HashMap<>();

        info.put("numClients", activeSessions.size());
        try {
            for (WebSocketSession s : activeSessions.values()) {
                s.sendMessage(new TextMessage(mapper.writeValueAsString(info)));
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * This method saves the incoming session to the activeSessions map and
     * broadcasts the new count to every single active WebSocket.
     * Executed after a client establishes a connection with the server.
     * @param session
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        activeSessions.put(session.getId(), session);
        broadcastSessionCount();
    }

    /**
     * This method removes the outcoming session from the activeSessions map and
     * broadcasts the new count to every single active WebSocket.
     * Executed after a client closes a connection with the server.
     * @param session
     * @param status
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        activeSessions.remove(session.getId());
        broadcastSessionCount();
    }
}
