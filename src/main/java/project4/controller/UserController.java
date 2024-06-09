package project4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project4.dto.request.UserRequest;
import project4.dto.response.UserResponse;
import project4.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

//
//    @PostMapping
//    public UserResponse createUser(@RequestBody UserRequest request) {
//        UserResponse user = userService.createUser(request);
//        return user;
//    }


    @GetMapping("list")
    public List<UserResponse> getAll() {
        return userService.getAllUser();
    }

    @GetMapping("/listUser")
    public String listUser(Model m) {
        m.addAttribute("lstUser", userService.getAllUser());
        return "admin/listUser";
    }

    @GetMapping("/createUser")
    public String showCreateUserForm(Model model) {
        return "admin/createUser";
    }


    @PostMapping
    public String createUser(@ModelAttribute UserRequest userRequest, Model model) {
        try {
            UserResponse userResponse = userService.createUser(userRequest);
            return "redirect:/users/listUser";
        } catch (Exception e) {
            model.addAttribute("message", "Error creating user: " + e.getMessage());
        }
        model.addAttribute("user", new UserRequest()); // Reset the form
        return "admin/createUser";
    }


}
