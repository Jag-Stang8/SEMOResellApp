package com.redacted.semoresellapp.repository;

import com.redacted.semoresellapp.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListingRepository extends JpaRepository<Listing, Long> {
    List<Listing> findByTitleContainingIgnoreCase(String title);
    List<Listing> findBySellerContainingIgnoreCase(String seller);
    List<Listing> findByPriceLessThan(Double price);

    //add other queries here
}
