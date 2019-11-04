package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@SpringBootApplication
public class Example410HelloWorldApplication {

	@RestController
	@RequestMapping("/hello")
	public static class HelloController {

		// http://localhost:8080/hello?name=ASW
		@GetMapping
		public String greet(@RequestParam String name) {
			return "Hello " + name + " " + LocalDateTime.now();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Example410HelloWorldApplication.class, args);
	}
}
