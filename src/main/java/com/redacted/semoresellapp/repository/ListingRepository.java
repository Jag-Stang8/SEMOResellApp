package com.redacted.semoresellapp.repository;

import com.redacted.semoresellapp.model.Listing;
import com.redacted.semoresellapp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingRepository extends CrudRepository<Listing, Long> {
    List<Listing> findBySeller(User seller);

    List<Listing> findByTitleContainingIgnoreCase(String title);

    List<Listing> findByPriceLessThan(double price);

    List<Listing> findByPriceGreaterThan(double price);

    List<Listing> findByPriceBetween(double minPrice, double maxPrice);
}
