package com.skillshare.student_skill_exchange.controller;


import com.skillshare.student_skill_exchange.entity.User;
import com.skillshare.student_skill_exchange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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


    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("users",
                userService.getAllUsers());

        return "dashboard";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }


    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user){

        System.out.println("REGISTER HIT");
        System.out.println(user.getName());
        System.out.println(user.getEmail());

        userService.registerUser(user);

        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String profile(Model model) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userService.findByEmail(email);

        model.addAttribute("user", user);

        return "profile";
    }
}
