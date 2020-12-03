package demo;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public Map<String,String> greet(@RequestParam(defaultValue = "World") String name) {
        return Map.of("msg","Hello " + name + " " + LocalDateTime.now());
    }

    // // http://localhost:8080/hello?name=ASW
    // @GetMapping(produces = "text/html")
    // public String greet(@RequestParam(defaultValue = "World") String name) {
    //     return "<h1>Hello " + name + " " + LocalDateTime.now() +"</h1>";
    // }
}

@RestController
class HelloController2 {

    @GetMapping("/hello2")
    public ResponseEntity<?> greet2(@RequestParam(defaultValue = "World") String name) {
        return ResponseEntity.ok()
                .header("my-response-header", "test")
                .body(Map.of("msg","Hello2 " + name + " " + LocalDateTime.now()));
    }
}