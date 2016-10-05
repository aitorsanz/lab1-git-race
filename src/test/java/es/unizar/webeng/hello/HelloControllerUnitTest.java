package es.unizar.webeng.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

 /**
  * This class is used to check if the message received from a client is
  * correct. Integration test should be used after Unit test because
  * it tests software modules (which are already correct) as a group.
  * {@RunWith} This annotation allows JUnit to invoke the SpringRunner class to run the tests in that class instead of the runner built into JUnit.
  * {@WebMvcTest} This annotation will disable full auto-configuration and instead apply only configuration relevant to MVC tests.
  */
@RunWith(SpringRunner.class) 
@WebMvcTest(HelloController.class)	
public class HelloControllerUnitTest {
		
	/**
	* This class is used to check if the messages received from a client are
	* correct. Integration test should be used after Unit test because
	* it tests software modules (which are already correct) as a group.
	* {@Value} This annotation indicates a default value expression ("Hello World") for the app.message argument.
	* {@Autowired} This annotation allows to auto wire bean on the field.
	*/

	@Value("${app.message:Hello World}") 
	private String message;	

    @Autowired 
    private HelloController controller;

	/**
	 * This test verifies that the String returned by HelloController.welcome is equal to "welcome", the map
	 * contains a key named "message", and the value of that key equals to the value assigned to [message]
	 *
	 * @throws Exception
     */
    @Test
    public void testMessage() throws Exception {
        HashMap<String,Object> map = new HashMap<>();
        String view = controller.welcome(map);
        assertThat(view, is("welcome"));
        assertThat(map.containsKey("message"), is(true));
        assertThat(map.get("message"), is(message));
    }
}
