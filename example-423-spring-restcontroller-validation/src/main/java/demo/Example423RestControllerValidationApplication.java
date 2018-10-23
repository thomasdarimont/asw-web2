package demo;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@SpringBootApplication
public class Example423RestControllerValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(Example423RestControllerValidationApplication.class, args);
	}
}

@Data
class User {

	@NotNull
	String username;

	String password;

	@Min(18)
	int age;
}

@RestController
@RequestMapping("/users")
class UserController {

	@PostMapping("/validate")
	public User validate(@Valid @RequestBody User user) {
		return user;
	}
}