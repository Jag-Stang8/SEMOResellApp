package com.redacted.semoresellapp.repository;

import com.redacted.semoresellapp.model.Customer;
import com.redacted.semoresellapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository {
    List<Order> findByCustomer(Customer customer);
    List<Order> findByTotalPriceLessThan(Double totalPrice);

    //Add other queries as needed
}
