package demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("greeting")
public class GreetingProperties {

    /**
     * Greeting message
     */
    private String message;

    /**
     * Number of times to greet
     */
    private int timesToGreet = 1;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTimesToGreet() {
        return timesToGreet;
    }

    public void setTimesToGreet(int timesToGreet) {
        this.timesToGreet = timesToGreet;
    }
}
