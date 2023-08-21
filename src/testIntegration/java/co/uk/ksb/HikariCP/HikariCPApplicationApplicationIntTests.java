package co.uk.ksb.HikariCP;

import co.uk.ksb.HikariCP.registration.RequestHeader;
import co.uk.ksb.HikariCP.registration.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(classes = HikariCPApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HikariCPApplicationApplicationIntTests {


	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testIntro() {
		assertTrue (this.restTemplate
				.getForObject("http://localhost:" + port + "/rest/intro", String.class).equals("SUCCESS"));
	}

	@Test
	public void testRegister() {
		UserRequest userRequest = new UserRequest();
		RequestHeader header = new RequestHeader();
		header.setRequestId("Test");
		header.setUsername("test");

		userRequest.setRequestHeader(header);
		userRequest.setSecureContext("Bhasker");
		UserRequest userRequest1 = this.restTemplate
				.postForObject("http://localhost:" + port + "/rest/register", userRequest, UserRequest.class);
		assertNotNull(userRequest1);
		assertNotNull(userRequest1.getSecureContext());

	}


}
