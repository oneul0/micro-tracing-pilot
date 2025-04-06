package mine.prac.apigateway.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RouteController {

	private final RestTemplate restTemplate;

	public RouteController(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

	@GetMapping("/gateway")
	public String routeToA() {
		return restTemplate.getForObject("http://localhost:8081/service-a/call-b", String.class);
	}
}

