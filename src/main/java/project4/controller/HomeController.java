package project4.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project4.configuration.CustomUser;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String index(Model model, Principal principal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated() && !(authentication.getPrincipal() instanceof String)) {
            String username = authentication.getName();
            model.addAttribute("username", username);
            model.addAttribute("isAuthenticated", true);
        } else {
            model.addAttribute("isAuthenticated", false);
        }
        return "views/index";
    }

    @GetMapping("/signin")
    public String login() {
        return "views/login";
    }


    @GetMapping("/register")
    public String register() {
        return "register";
    }


    @GetMapping("/viewProduct")
    public String viewProduct() {
        return "views/viewProduct";
    }



    @GetMapping("/access-denied")
    public String error() {
        return "error-403";
    }


    @GetMapping("/order")
    public String order() {
        return "admin/order";
    }
}
