package demo;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.annotation.XmlRootElement;

@SpringBootApplication
public class Example424RestControllerContentNegotiationApp {

    public static void main(String[] args) {
        SpringApplication.run(Example424RestControllerContentNegotiationApp.class, args);
    }
}

@Data
@XmlRootElement
class User {

    private String username;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }
}

@RestController
@RequestMapping("/users")
class UserController {

    @GetMapping(produces = {
              MediaType.APPLICATION_JSON_VALUE
            , MediaType.APPLICATION_XML_VALUE
    })
    public User getDemoUser() {
        return new User("Asterix");
    }
}