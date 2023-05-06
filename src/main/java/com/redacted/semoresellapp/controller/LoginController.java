package com.redacted.semoresellapp.controller;

import com.redacted.semoresellapp.model.User;
import com.redacted.semoresellapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String showLoginPage() {
        return "login.html";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String username, @RequestParam("password") String password, Model model) {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent())
            if(user.get().getPassword().equals(password))
                return "redirect:/homepage.html";
            else {
                model.addAttribute("error", "Invalid username or password");
                return "login.html";
            }
        else {
            model.addAttribute("error", "Invalid username or password");
            return "login.html";
        }
    }
}
