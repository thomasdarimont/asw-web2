package demo;

import java.time.Instant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
public class Example425SpringMvcIntro {

	public static void main(String[] args) {
		SpringApplication.run(Example425SpringMvcIntro.class, args);
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
@RequestMapping("/greeting")
class GreetingController {

	/**
	 * @param model, the "Model" part of the MVC pattern
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String showGreeting(Model model) {

		model.addAttribute("greeting", new Greeting("Hello World " + Instant.now()));

		// the "View" part of the MVC pattern -> looks for greeting-view.html in src/main/resources/templates by default
		return "greeting-view";
	}
}