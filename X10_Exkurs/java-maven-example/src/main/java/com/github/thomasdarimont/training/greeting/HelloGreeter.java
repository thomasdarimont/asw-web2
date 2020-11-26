package com.github.thomasdarimont.training.greeting;

import java.util.Objects;

public class HelloGreeter implements Greeter {


    public String greet(String name) {

        Objects.requireNonNull(name, "must not be null");

        return "Hello " + name;
    }
}
