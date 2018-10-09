package demo;

import java.time.Instant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class Example445SpringMvcWithJsp extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Example445SpringMvcWithJsp.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Example445SpringMvcWithJsp.class, args);
	}
}

class Greeting {

	String message;

	public Greeting(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

/**
 * The "Controller" part of the MVC pattern
 */
@Controller
class GreetingController {

	/**
	 * @param model, the "Model" part of the MVC pattern
	 * @return
	 */
	@GetMapping("/greeting")
	public String showGreeting(Model model) {

		model.addAttribute("greeting", new Greeting("Hello World " + Instant.now()));

		// the "View" part of the MVC pattern -> looks for greeting-view.jsp in
		// src/main/resources/templates
		return "greeting-view";
	}
}