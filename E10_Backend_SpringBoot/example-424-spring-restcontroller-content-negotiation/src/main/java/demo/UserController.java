package demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
class UserController {

    /**
     * Controller Methode die Userinformationen im XML und JSON Format zurückgeben kann.
     * <pre>
     * {@code
     * curl -s -H "Accept: application/json" http://localhost:8080/users/demo
     *
     * curl -s -H "Accept: application/xml" http://localhost:8080/users/demo
     * }
     * </pre>
     *
     * @return
     */
    @GetMapping(path = "demo", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public User getDemoUser() {
        return new User("Bob", 22);
    }

}
