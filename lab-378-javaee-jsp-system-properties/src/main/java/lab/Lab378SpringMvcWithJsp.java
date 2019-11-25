package lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Run with "Run as Java Application" or run in console via:
 * {@code mvn clean spring-boot:run}
 */
@SpringBootApplication
public class Lab378SpringMvcWithJsp extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Lab378SpringMvcWithJsp.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Lab378SpringMvcWithJsp.class, args);
	}
}

@Controller
class JspController {

	@GetMapping(path="/system-properties")
	String getPage() {
		return "system-properties";
	}
}