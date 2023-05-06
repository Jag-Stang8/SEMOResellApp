package com.redacted.semoresellapp.repository;

import com.redacted.semoresellapp.model.Checkout;
import com.redacted.semoresellapp.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CheckoutRepository extends CrudRepository<Checkout, Long> {
    List<Checkout> findByBuyer(User buyer);
}
