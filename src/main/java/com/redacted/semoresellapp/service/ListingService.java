package com.redacted.semoresellapp.service;

import com.redacted.semoresellapp.model.Listing;
import com.redacted.semoresellapp.repository.ListingRepository;
import exception.ListingNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListingService {
    @Autowired
    private ListingRepository listingRepository;

    public ListingService(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    public List<Listing> getAllListings() {
        return (List<Listing>) listingRepository.findAll();
    }

    public Listing getListingById(Long id) {
        Optional<Listing> optionalListing = listingRepository.findById(id);
        if(optionalListing.isPresent())
            return optionalListing.get();
        else
            throw new ListingNotFoundException("No Listing with id: " + id + " found");
    }

    public Listing createListing(Listing listing) {
        return listingRepository.save(listing);
    }

    public Listing updateListing(Long id, Listing updatedListing) {
        Listing listing = getListingById(id);
        listing.setTitle(updatedListing.getTitle());
        listing.setDesc(updatedListing.getDesc());
        listing.setImage(updatedListing.getImage());
        listing.setPrice(updatedListing.getPrice());

        return listingRepository.save(listing);
    }

    public void deleteListing(Long id) {
        listingRepository.deleteById(id);
    }

}
