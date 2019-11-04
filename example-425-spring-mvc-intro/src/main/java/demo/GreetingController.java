package demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The "Controller" part of the MVC pattern
 */
@Controller
@RequestMapping("/greeting")
class GreetingController {

    /**
     * @param model, the "Model" part of the MVC pattern, automatically provided by Spring MVC
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showGreeting(@RequestParam(defaultValue = "World") String name, Model model) {

        Greeting greeting = new Greeting(name);
        // bind Greeting instance to the model attribute "greeting"
        model.addAttribute("greeting", greeting);

        // the "View" part of the MVC pattern
        // looks for 'greeting-view.html' in src/main/resources/templates by default
        return "greeting-view";
    }
}
