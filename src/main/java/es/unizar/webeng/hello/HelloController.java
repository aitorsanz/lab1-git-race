package es.unizar.webeng.hello;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@Value("${app.message:Hello World}")
	private String message;	
	@RequestMapping("/") //Annotation for mapping web requests onto specific handler classes and/or handler methods.
	public String welcome(Map<String, Object> model) {
		//Puts in the key "time" a new date.
		model.put("time", new Date());
		//Puts in the key "message", the value assigned to [message]
		model.put("message", message);
		return "wellcome";
	}		
}
