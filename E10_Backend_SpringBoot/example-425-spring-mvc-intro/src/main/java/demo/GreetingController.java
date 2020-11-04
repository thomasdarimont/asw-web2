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
     * @param name,  a Request parameter with the default value "World"
     * @param model, the "Model" part of the MVC pattern, automatically provided by Spring MVC. Model data is available in the View template.
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showGreeting( // The Request param can be provided via an URL parameter
                                @RequestParam(defaultValue = "World") String name, //

                                // The Model instance can be used to expose data to the view template
                                Model model //
    ) {

        Greeting greeting = new Greeting(name);
        // bind Greeting instance to the model attribute "greeting"
        // this makes the value available via "greeting" in the view template
        model.addAttribute("greeting", greeting);

        // the "View" part of the MVC pattern
        // looks for 'greeting-view.html' in src/main/resources/templates by default
        return "greeting-view";
    }
}
