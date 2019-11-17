package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * java -Dgreeting.message=Huhu -jar target/example-405-spring-configuration-properties-0.0.1-SNAPSHOT.jar
 * java -Dgreeting.message=Huhu -Dgreeting.timesToGreet=3 -jar target/example-405-spring-configuration-properties-0.0.1-SNAPSHOT.jar
 *
 * Linux / Cygwin:
 * GREETING_MESSAGE=Hallo java -Dgreeting.timesToGreet=3 -jar target/example-405-spring-configuration-properties-0.0.1-SNAPSHOT.jar
 *
 * Windows
 * set GREETING_MESSAGE=Hallo
 * java -Dgreeting.timesToGreet=3 -jar target/example-405-spring-configuration-properties-0.0.1-SNAPSHOT.jar
 */
@SpringBootApplication
public class Example405SpringConfigurationPropertiesApplication {

    public static void main(String[] args) {

        var container = SpringApplication.run(Example405SpringConfigurationPropertiesApplication.class, args);

        Greeter greeter = container.getBean(Greeter.class);

        greeter.printGreeting("ASW Class");
    }

}
