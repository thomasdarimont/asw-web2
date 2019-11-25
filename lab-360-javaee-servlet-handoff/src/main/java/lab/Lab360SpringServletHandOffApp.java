package lab;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan // Required to find Servlet API components on class-path
public class Lab360SpringServletHandOffApp {

	public static void main(String[] args) {
		SpringApplication.run(Lab360SpringServletHandOffApp.class, args);
	}
}
