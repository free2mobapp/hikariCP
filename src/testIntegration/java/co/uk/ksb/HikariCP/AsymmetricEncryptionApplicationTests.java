package co.uk.ksb.HikariCP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(classes = AsymmetricEncryptionApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AsymmetricEncryptionApplicationTests {


	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testIntro() {
		assertTrue (this.restTemplate
				.getForObject("http://localhost:" + port + "/rest/intro", String.class).equals("SUCCESS"));
	}



}
