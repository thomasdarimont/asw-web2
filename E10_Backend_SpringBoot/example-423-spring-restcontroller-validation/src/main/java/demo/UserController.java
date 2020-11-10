package demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
class UserController {

    /**
     * <pre>
     * {@code
     *
     * curl -v -X POST -H "Content-type: application/json" -d '{ "username":"Tester", "password":"test1234", "age":18 }' http://localhost:8080/users/validate
     *
     * curl -v -X POST -H "Content-type: application/json" -d '{ "username":"Tester", "password":"test1234", "age":17 }' http://localhost:8080/users/validate
     *
     * curl -v -X POST -H "Content-type: application/json" -d '{ "password":"test1234", "age":35 }' http://localhost:8080/users/validate
     * }
     * </pre>
     *
     * @param user
     * @return
     */
    @PostMapping("/validate")
    public User validate(@Valid @RequestBody User user) {
        return user;
    }
}
