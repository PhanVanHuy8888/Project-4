package project4.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/index")
    public String index(Model model) {
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
        return "views/register";
    }


    @GetMapping("/viewProduct")
    public String viewProduct(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated() && !(authentication.getPrincipal() instanceof String)) {
            String username = authentication.getName();
            model.addAttribute("username", username);
            model.addAttribute("isAuthenticated", true);
        } else {
            model.addAttribute("isAuthenticated", false);
        }
        return "views/viewProduct";
    }



    @GetMapping("/access-denied")
    public String error() {
        return "error-403";
    }

    @GetMapping("/cart")
    public String cart() {
        return "views/listCart";
    }

    @GetMapping("/checkout")
    public String order() {
        return "views/checkout";
    }


    @GetMapping("/success")
    public String success() {
        return "views/success";
    }

    @GetMapping("/products")
    public String chocolate(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated() && !(authentication.getPrincipal() instanceof String)) {
            String username = authentication.getName();
            model.addAttribute("username", username);
            model.addAttribute("isAuthenticated", true);
        } else {
            model.addAttribute("isAuthenticated", false);
        }
        return "views/chocolate";
    }
    @GetMapping("/contact")
    public String contact(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated() && !(authentication.getPrincipal() instanceof String)) {
            String username = authentication.getName();
            model.addAttribute("username", username);
            model.addAttribute("isAuthenticated", true);
        } else {
            model.addAttribute("isAuthenticated", false);
        }
        return "views/contact";
    }

    @GetMapping("/search")
    public String search() {
        return "/views/searchProduct";
    }
}
