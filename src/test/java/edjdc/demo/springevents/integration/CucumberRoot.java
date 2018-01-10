package edjdc.demo.springevents.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;

import edjdc.demo.springevents.DemoSpringEventsApplication;

@SpringBootTest(classes = DemoSpringEventsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class CucumberRoot {

	@Autowired
	protected TestRestTemplate template;
	
}
