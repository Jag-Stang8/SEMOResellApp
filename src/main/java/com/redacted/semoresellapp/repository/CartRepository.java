package com.redacted.semoresellapp.repository;

import com.redacted.semoresellapp.model.Cart;
import com.redacted.semoresellapp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
    List<Cart> findByUser(User user);
}
