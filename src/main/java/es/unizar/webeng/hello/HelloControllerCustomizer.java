package es.unizar.webeng.hello;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * This class implements a server customizer by adding support to
 * additional features like custom error pages
 */
@Component
public class HelloControllerCustomizer implements EmbeddedServletContainerCustomizer {

    /**
     * This method adds support for the NOT FOUND http error (404) without
     * interfering with the URI mapping that Spring does. It redirects any "Not
     * Found petition" to the "/404" URI handler
     */
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
    }
}
