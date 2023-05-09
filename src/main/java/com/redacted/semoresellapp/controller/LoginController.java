package com.redacted.semoresellapp.controller;

import com.redacted.semoresellapp.repository.UserRepository;
import com.redacted.semoresellapp.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = {"/", "/login"})
    public String showLoginForm(Model model) {
        return "login.html";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        System.out.println("Entered login POST controller");
        if (userService.isValidUser(username, password)) {
            // redirect to home page if user is authenticated
            Long userId = userRepository.findByUsername(username).get().getId();
            session.setAttribute("userId", userId);
            return "redirect:/homepage";
        } else {
            // add an error message to the model if authentication fails
            model.addAttribute("errorMessage", "Invalid email or password");
        }

        return "redirect:/login";
    }
}
