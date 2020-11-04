package lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Run with "Run as Java Application" or run in console via:
 * {@code mvn clean spring-boot:run}
 */
@SpringBootApplication
@ServletComponentScan // Required to find Servlet API components on class-path
public class Lab390SpringMvcWithJspGuessMyNumberGame extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Lab390SpringMvcWithJspGuessMyNumberGame.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Lab390SpringMvcWithJspGuessMyNumberGame.class, args);
	}
}

@Controller
class JspController {

	@RequestMapping(path = "/game", method = {RequestMethod.GET, RequestMethod.POST})
	String getPage() {
		return "game";
	}
}