package project4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String index() {
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
