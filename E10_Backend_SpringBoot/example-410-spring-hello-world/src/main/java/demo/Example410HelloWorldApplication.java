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

    public static void main(String[] args) {
        SpringApplication.run(Example410HelloWorldApplication.class, args);
    }
}

@RestController
@RequestMapping("/hello")
class HelloController {

    // http://localhost:8080/hello?name=ASW
    @GetMapping
    public String greet(@RequestParam(defaultValue = "World") String name) {
        return "Hello " + name + " " + LocalDateTime.now();
    }

    // // http://localhost:8080/hello?name=ASW
    // @GetMapping(produces = "text/html")
    // public String greet(@RequestParam(defaultValue = "World") String name) {
    //     return "<h1>Hello " + name + " " + LocalDateTime.now() +"</h1>";
    // }
}
