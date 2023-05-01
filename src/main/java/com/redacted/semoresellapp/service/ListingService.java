package com.redacted.semoresellapp.service;

import com.redacted.semoresellapp.model.Listing;
import com.redacted.semoresellapp.repository.ListingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingService {
    private ListingRepository listingRepository;

    public ListingService(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    public List<Listing> searchListings(String keyword) {
        return listingRepository.findByTitleContainingIgnoreCase(keyword);
    }

    public Listing getListingById(Long id) {
        return listingRepository.findById(id).orElse(null);
    }

    public void saveListing(Listing listing) {
        listingRepository.save(listing);
    }

    public void deleteListing(Long id) {
        listingRepository.deleteById(id);
    }

    //Add other methods as needed
}
