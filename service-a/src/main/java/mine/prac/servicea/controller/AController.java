package mine.prac.servicea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/service-a")
@RequiredArgsConstructor
public class AController {

	private final RestTemplate restTemplate;

	@GetMapping("/call-b")
	public String callServiceB() {
		String response = restTemplate.getForObject("http://localhost:8082/service-b/hello", String.class);
		return "A → " + response;
	}
}


