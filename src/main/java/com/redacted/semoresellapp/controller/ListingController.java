package com.redacted.semoresellapp.controller;

import com.redacted.semoresellapp.model.Listing;
import com.redacted.semoresellapp.repository.ListingRepository;
import com.redacted.semoresellapp.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListingController {
    @Autowired
    private ListingRepository listingRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/listitem")
    public String showForm(Model model) {
        System.out.println("Entered listanitem GET");
        return "listanitem.html";
    }

    @PostMapping("/listitem")
    public String submitForm(@RequestParam("title") String title, @RequestParam("desc") String desc, @RequestParam("price") double price, @RequestParam("image") String image, HttpSession session) {
        System.out.println("Entered listanitem POST");

        Listing listing = new Listing(title, desc, image, price, userService.getUserById((Long) session.getAttribute("userId")));

        listingRepository.save(listing);
        return "redirect:/homepage"; // change this to the URL of the success page
    }
}
