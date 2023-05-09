package com.redacted.semoresellapp.controller;

import com.redacted.semoresellapp.model.User;
import com.redacted.semoresellapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        System.out.println("Inside /register GET");
        return "register.html";
    }

    @PostMapping("/register")
    public String register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword, Model model) {
        System.out.println("Inside /register POST");
        if(password.equals(confirmPassword)) {
            userService.createUser(new User(username, password));
            return "redirect:/login";
        }
        else {
            return "redirect:/register";
        }
    }
}
