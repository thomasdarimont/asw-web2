package demo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
class User {

    @NotNull
    String username;

    String password;

    @Min(18)
    int age;
}
