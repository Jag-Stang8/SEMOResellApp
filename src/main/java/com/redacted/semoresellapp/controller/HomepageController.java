package com.redacted.semoresellapp.controller;

import com.redacted.semoresellapp.model.Listing;
import com.redacted.semoresellapp.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomepageController {
    @Autowired
    ListingRepository listingRepository;

    @GetMapping("/homepage")
    public String homepage(Model model) {
        List<Listing> listings = (List<Listing>) listingRepository.findAll();
        System.out.println(listings);
        model.addAttribute("listings", listings);

        return "homepage.html";
    }
}
