package es.unizar.webeng.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/** 
 *	This class allows you to run a Spring application from a traditional WAR deployment.
 *	Binds Servlet, Filter and ServletContextInitializer beans from the application context to the servlet container.
 *  (WebApplicationInitializer is only needed if you are building a war file and deploying it.
 *   If you prefer to run an embedded container then you won't need this at all.)
 */
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Application extends SpringBootServletInitializer {

    /**
     * Main method uses SpringApplication.run() to launch de application.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
	/**
	 *  Creates a new SpringApplication instances from the given sources (application). 
	 *  Subclasses may override in order to provide a custom subclass of SpringApplication
	 */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}