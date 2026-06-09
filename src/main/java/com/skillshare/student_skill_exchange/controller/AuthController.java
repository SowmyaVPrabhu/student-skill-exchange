package com.skillshare.student_skill_exchange.controller;


import com.skillshare.student_skill_exchange.entity.User;
import com.skillshare.student_skill_exchange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;


    @GetMapping("/signup")
    public String showSignipPage(){
        return "signup";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user){
        userService.registerUser(user);

        return "redirect:/signup";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("users",
                userService.getAllUsers());

        return "dashboard";
    }
}
