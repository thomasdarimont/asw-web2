package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Example400HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(Example400HelloWorldApplication.class, args);
		
		System.out.printf("%n#### Hello Minimal Spring Boot App%n%n");
	}
}
