package es.unizar.webeng.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * This class implemets a server that capture a petition from a client
 * and if the petition is allright formed server return wellcome.jsp page
 * (located in main/webapp/WEB-INF/jsp/wellcome.jsp) containing
 * the date of the petition and the number of visitor to the page.
 * If the petition is bad matched server return a error page 404.jsp
 * (located in main/webapp/WEB-INF/jsp/404.jsp).
 */
@Controller
public class HelloController {

    @Value("${app.message:Hello World}")
    private String message;                                     // A simple message to display

    private AtomicInteger hitCounter = new AtomicInteger(0);    // A simple visit counter

    // A syncronized list which stores the latest 10 connections that are made to the web server
    private LinkedList<String> logList = new LinkedList<String>();
    private List<String> connectLogs = Collections.synchronizedList(logList);

    /**
     * <p>This method captures a petition when every single other controller method couldn't get a matched url, and
     * returns a custom 404 page.</p>
     * <p>Note: The headers are restricted to not "Upgrade" so that it doesn't respond with HTTP 200 to WebSocket requests
     * @see <a href="http://stackoverflow.com/questions/38376316/handle-the-same-url-with-spring-mvc-requestmappinghandlermapping-and-spring-webs">
     *     StackOverflow - Handle the same URL with Spring MVC RequestMappingHandlerMapping and Spring Websocket's ServletWebSocketHandlerRegistry</a></p>
     * @return A custom 404 page found in /src/main/webapp/WEB-INF/jsp/404.jsp
     */
    @RequestMapping(value = "/*", method = RequestMethod.GET, headers = "Connection!=Upgrade")
    public String notFound() {
        return "404";
    }

    /**
     * This method captures a petition made to /home and then returns a sample page containing the current date of the
     * person making the petition as well as a message that can be customized /src/resources/application.properties
     * @param model a simple map for a correlation between variable names and their corresponding value
     * @return sample web page contained in /src/main/webapp/WEB-INF/jsp/welcome.jsp
     */
    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
    	
        // Puts in the key "time" a new date.
    	Date time = new Date();
        model.put("time", time);
        
        // Puts in the key "message", the value assigned to [message]
        model.put("message", message);
        
        // A simple counter that will store the amount of times the url "/" has been visited.
        // The counter needs to be incremented atomically as the method is executed whenever a user requests the root
        // page concurrently
        model.put("hitCounter", hitCounter.incrementAndGet());    

        // It stores the moment of time in which a user connects to the web server home page
        saveLastConnections(time);
        
        return "welcome";
    }
    
    /**
     * This method captures a request made to /last and then returns a sample 
     * page containing a log with the latest 10 connections that are made to the web server.
     * @param model a simple map for a correlation between variable names and their corresponding value
     * @return A sample web page contained in /src/main/webapp/WEB-INF/jsp/lastConnections.jsp
     */
    @RequestMapping("/last")
    public String lastConnections(Map<String, Object> model) {
    	       
        // Puts in the key "logs", the value assigned to the list of the latest 10 connections
        model.put("connectLogs",connectLogs);
    	
    	return "lastConnections";
    }
    
    /**
     * Method that store a log of the latest 10 connections to the web server
     * @param time the moment of the time in which user connects to the web server
     */
    private void saveLastConnections(Date time){
    	
    	// A list that stores the moments of time in which a user connects to 
    	// the web server.It stores the latest connections first.
        // Moreover, the number of connections that are stored are limited to 
    	// the last 10 to prevent denial of service attacks.
        synchronized (connectLogs) {
        	logList.addFirst(time.toString());
        }   
        if(hitCounter.get() >= 10){
        	synchronized (connectLogs) {
        		logList.removeLast();
            }
        } 
    }
}
