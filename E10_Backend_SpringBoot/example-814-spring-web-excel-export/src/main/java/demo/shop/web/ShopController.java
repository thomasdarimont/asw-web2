package demo.shop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class ShopController {

    @GetMapping("/")
    public String index() {
        return "redirect:/products";
    }
}
