package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * {@code mvn clean spring-boot:run}
 */
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
