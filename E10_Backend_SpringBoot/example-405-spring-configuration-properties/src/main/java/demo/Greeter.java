package demo;

import org.springframework.stereotype.Component;

@Component
public class Greeter {

    private final GreetingProperties greetingProperties;

    public Greeter(GreetingProperties greetingProperties) {
        this.greetingProperties = greetingProperties;
    }

    public void printGreeting(String name) {

        for (int i = 0; i < greetingProperties.getTimesToGreet(); i++) {
            System.out.println(greetingProperties.getMessage() + " " + name);
        }
    }
}
