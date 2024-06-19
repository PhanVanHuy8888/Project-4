package project4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/createUser")
    public String createUser() {
        return "admin/createUser";
    }

    @GetMapping("/editUser")
    public String editUser() {
        return "admin/editUser";
    }

    @GetMapping("/listUser")
    public String getAllUser() {
        return "admin/listUser";
    }

    @GetMapping("/listProduct")
    public String getAllProduct() {
        return "admin/listProduct";
    }

    @GetMapping("/listCategory")
    public String getAllCategory() {
        return "admin/listCategory";
    }

    @GetMapping("/addProduct")
    public String createProduct(){
        return "admin/addProduct";
    }

    @GetMapping("/createCate")
    public String createCate(){
        return "admin/createCate";
    }
}
