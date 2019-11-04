package demo;

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

@XmlRootElement
class User {

    private String username;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

@RestController
@RequestMapping("/users")
class UserController {

    /**
     * <pre>
     * {@code
     * curl -v -H "Accept: application/json" http://localhost:8080/users/demo
     *
     * curl -v -H "Accept: application/xml" http://localhost:8080/users/demo
     * }
     * </pre>
     *
     * @return
     */
    @GetMapping(
            path = "demo",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
                    , MediaType.APPLICATION_XML_VALUE
            })
    public User getDemoUser() {
        return new User("Asterix");
    }

}