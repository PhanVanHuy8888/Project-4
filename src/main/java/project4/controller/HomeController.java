package project4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "admin/index";
    }

    @GetMapping("/index")
    public String index() {
        return "views/index";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }


    @GetMapping("/register")
    public String register() {
        return "register";
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
