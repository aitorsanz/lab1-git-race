package es.unizar.webeng.hello;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // Tells JUnit to invoke the Spring test wrapper which allows the Web App Context to be loaded. 
@WebMvcTest(HelloController.class) // Annotation indicating a Spring MVC test over the controller "HelloCOntroller". 
public class StaticContentUnitTest {

	@Autowired
    private WebApplicationContext wac;

	@Value("${app.message:Hello World}") //Annotation at the field that indicates a default value expression for the affected argument.
	private String message;	

	private MockMvc mockMvc;

	/**
	 * The @Before label indicates that this method 
	 * will be executed before running any tests
	 */
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    
    /**
     * The following method is an integrated test that checks 
     * if the messages are correct.
     * 
     * When this method is executed it checks that the value of 
     * message is "message" and that the request has returned 
     * something valid, after having made a petition to "/" 
     * and having printed ()
     * 
     * @throws Exception
     */
    @Test
    public void testMessage() throws Exception {
        this.mockMvc.perform(get("/"))
        	.andDo(print())
            .andExpect(status().isOk())
            .andExpect(model().attribute("message", is(message)));
    }    
}
