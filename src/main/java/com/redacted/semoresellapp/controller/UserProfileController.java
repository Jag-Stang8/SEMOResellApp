package com.redacted.semoresellapp.controller;

import com.redacted.semoresellapp.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserProfileController {
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String showForm(Model model, HttpSession session) {
        System.out.println("Entered profile GET");

        model.addAttribute("username", userService.getUserById((Long) session.getAttribute("userId")).getUsername());

        return "profile.html";
    }
}
