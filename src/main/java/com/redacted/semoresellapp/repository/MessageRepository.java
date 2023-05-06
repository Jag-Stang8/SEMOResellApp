package com.redacted.semoresellapp.repository;

import com.redacted.semoresellapp.model.Listing;
import com.redacted.semoresellapp.model.Message;
import com.redacted.semoresellapp.model.Order;
import com.redacted.semoresellapp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findBySender(User sender);

    List<Message> findByRecipient(User recipient);

    List<Message> findByListing(Listing listing);

    List<Message> findByOrder(Order order);
}
