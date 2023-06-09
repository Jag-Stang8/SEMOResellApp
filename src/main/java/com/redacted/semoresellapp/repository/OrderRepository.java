package com.redacted.semoresellapp.repository;

import com.redacted.semoresellapp.model.Listing;
import com.redacted.semoresellapp.model.Order;
import com.redacted.semoresellapp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByBuyer(User buyer);

    List<Order> findByListing(Listing listing);

    List<Order> findBySeller(User seller);
}
