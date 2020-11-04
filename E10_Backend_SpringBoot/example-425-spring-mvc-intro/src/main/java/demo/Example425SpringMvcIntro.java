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

