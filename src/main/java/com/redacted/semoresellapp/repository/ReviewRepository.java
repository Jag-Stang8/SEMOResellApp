package com.redacted.semoresellapp.repository;

import com.redacted.semoresellapp.model.Order;
import com.redacted.semoresellapp.model.Review;
import com.redacted.semoresellapp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findByOrder(Order order);

    List<Review> findBySeller(User seller);

    List<Review> findByBuyer(User buyer);
}
