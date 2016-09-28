package es.unizar.webeng.hello;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HelloController {
	
	/**
	 * This class implemets a server that capture a petition from a client
	 * and if the petition is allright formed server return wellcome.jsp page 
	 * (located in main/webapp/WEB-INF/jsp/wellcome.jsp) containing
	 * the date of the petition and the number of visitor to the page.
	 * If the petition is bad matched server return a error page 404.jsp
	 * (located in main/webapp/WEB-INF/jsp/404.jsp).
	 */
	
	
	@Value("${app.message:Hello World}")
	private String message;
	
	@Value("${app.count}")
	private int count; //counter used to track the number of visits made to the url "/"

	/**
	 * This method captures a petition when every single other controller method couldn't get a matched url, and
	 * returns a custom 404 page.
	 * @return custom 404 page found in /src/main/webapp/WEB-INF/jsp/404.jsp
	 */
	@RequestMapping(value = "/*")
	public String notFound() {
		return "404";
	}

	/**
	 * This method captures a petition made to /home and then returns a sample page containing the current date of the
	 * person making the petition as well as a message that can be customized /src/resources/application.properties
	 * @param model a simple map for a correlation between variable names and their corresponding value
	 * @return sample web page contained in /src/main/webapp/WEB-INF/jsp/wellcome.jsp
	 */
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		//Puts in the key "time" a new date.
		model.put("time", new Date());
		//Puts in the key "message", the value assigned to [message]
		model.put("message", message);

		//A simple counter that will show the amount of times that the client has visited the url "/"
		model.put("count", count);
		count++;
		return "wellcome";
	}
}
