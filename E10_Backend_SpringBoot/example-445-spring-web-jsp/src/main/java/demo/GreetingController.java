package demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Instant;

/**
 * http://localhost:8080/greeting
 *
 * The "Controller" part of the MVC pattern
 */
@Controller
class GreetingController {

    /**
     * @param model, the "Model" part of the MVC pattern
     * @return
     */
    @GetMapping("/greeting")
    public String showGreeting(Model model) {

        model.addAttribute("greeting", new Greeting("Hello World " + Instant.now()));

        // the "View" part of the MVC pattern -> looks for greeting-view.jsp in
        // src/main/webapp/WEB-INF/jsp as is configured by src/main/resources/application.properties
        return "greeting-view";
    }
}