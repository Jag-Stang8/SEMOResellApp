package com.redacted.semoresellapp.repository;

import com.redacted.semoresellapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByEmailContainingIgnoreCase(String email);

    //add other queries as needed
}
