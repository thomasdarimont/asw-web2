package demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
class NewsletterController {

    @GetMapping("/")
    public String index() {
        return "redirect:/newsletter";
    }

    @GetMapping("/newsletter")
    public String showNewsletterForm() {
        return "newsletter";
    }

    // Variant 1: Process POST Form Data and Render Page directly
    // (1) POST Form data
    @PostMapping("/newsletter/register")
    public String processForm(@RequestParam(name = "email") String email, Model model) {

        model.addAttribute("email", email);

        // Render page with Model attributes
        return "registered";
    }

//    // Variant 2: POST, Redirect, GET: Process POST Form Data, add data to session, Redirect to Page, Render page on GET
//    // (1) POST Form data
//    @PostMapping("/newsletter/register")
//    public String processForm(@RequestParam(name = "email") String email, HttpSession session) {
//
//        session.setAttribute("email", email);
//
//        // (2) Redirect to
//        return "redirect:/newsletter/registered";
//    }
//
//    // (3) GET
//    @GetMapping("/newsletter/registered")
//    public String showRegistrationComplete(HttpSession httpSession, Model model) {
//
//        model.addAttribute("email", httpSession.getAttribute("email"));
//
//        return "registered";
//    }
}
