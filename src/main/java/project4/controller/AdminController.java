package project4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/createUser")
    public String createUser() {
        return "admin/createUser";
    }

    @GetMapping("/listUser")
    public String getAllUser() {
        return "admin/listUser";
    }

}
