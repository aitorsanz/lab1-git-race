package es.unizar.webeng.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * This class is used to check if the messages that are sent to the server
 * contain what they are supposed to have. Integration test should be used
 * after Unit test because it tests software modules (witch are alredy
 * correct) as a group.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@DirtiesContext
public class IntegrationTest {


    @Value("${local.server.port}")
    private int port = 0;

    /**
     * The objective of this test is to check the connection to the Home page.
     * This method will throw an exception if the connection fails or if the
     * body of the page is not correct.
     *
     * @throws Exception
     *             if the connection failed or if the body of the page is not
     *             correct
     */
    @Test
    public void testHome() throws Exception {
        ResponseEntity<String> entity = new TestRestTemplate().getForEntity("http://localhost:" + this.port,
                String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertTrue("Wrong body (title doesn't match):\n" + entity.getBody(), entity.getBody().contains("<title>Hello"));
    }

    /**
     * Send a GET message to the server with the path
     * "/webjars/bootstrap/3.3.5/css/bootstrap.min.css" and check if the server
     * response is OK (200). It also checks if the response contains the text
     * "body", if that's the case, shows a warning message. If the specified
     * Content-Type header is not "text/css", show a warning message.
     */
    @Test
    public void testCss() throws Exception {
        ResponseEntity<String> entity = new TestRestTemplate().getForEntity(
                "http://localhost:" + this.port + "/webjars/bootstrap/3.3.5/css/bootstrap.min.css", String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertTrue("Wrong body:\n" + entity.getBody(), entity.getBody().contains("body"));
        assertEquals("Wrong content type:\n" + entity.getHeaders().getContentType(), MediaType.valueOf("text/css"),
                entity.getHeaders().getContentType());
    }
}
