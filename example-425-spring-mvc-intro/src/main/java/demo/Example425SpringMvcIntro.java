package demo;

import java.time.Instant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @see http://localhost:8080/greeting
 */
@SpringBootApplication
public class Example425SpringMvcIntro {

	public static void main(String[] args) {
		SpringApplication.run(Example425SpringMvcIntro.class, args);
	}
}

// The data object of our 'Model'
@Data
@AllArgsConstructor
class Greeting {

	String message;
}

/**
 * The "Controller" part of the MVC pattern  
 */
@Controller
@RequestMapping("/greeting")
class GreetingController {

	/**
	 * @param model, the "Model" part of the MVC pattern, automatically provided by Spring MVC
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String showGreeting(Model model) {

		Greeting greeting = new Greeting("Hello World " + Instant.now());
		model.addAttribute("greeting", greeting);

		// the "View" part of the MVC pattern
		// looks for 'greeting-view.html' in src/main/resources/templates by default
		return "greeting-view";
	}
}