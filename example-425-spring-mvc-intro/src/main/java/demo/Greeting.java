package demo;

import java.time.Instant;

// The data object of our 'Model'
class Greeting {

    private final String name;

    public Greeting(String name) {
        this.name = name;
    }

    public String getMessage() {
        return "Hello " + name + " " + Instant.now();
    }
}
