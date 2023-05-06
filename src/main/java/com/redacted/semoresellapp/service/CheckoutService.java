package com.redacted.semoresellapp.service;

import com.redacted.semoresellapp.model.Checkout;
import com.redacted.semoresellapp.model.Order;
import com.redacted.semoresellapp.model.User;
import com.redacted.semoresellapp.repository.CheckoutRepository;
import com.redacted.semoresellapp.exception.CheckoutNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CheckoutService {
    @Autowired
    private CheckoutRepository checkoutRepository;

    public CheckoutService(CheckoutRepository checkoutRepository) {
        this.checkoutRepository = checkoutRepository;
    }

    public List<Checkout> getAllCheckouts() {
        return (List<Checkout>) checkoutRepository.findAll();
    }

    public Checkout getCheckoutById(Long id) {
        Optional<Checkout> optionalCheckout = checkoutRepository.findById(id);
        if(optionalCheckout.isPresent())
            return optionalCheckout.get();
        else
            throw new CheckoutNotFoundException("No Checkout with id: " + id + " found");
    }

    public Checkout createCheckout(Checkout checkout) {
        return checkoutRepository.save(checkout);
    }

    public Checkout updateCheckout(Long id, Checkout updatedCheckout) {
        Checkout checkout = getCheckoutById(id);
        checkout.setBuyer(updatedCheckout.getBuyer());
        checkout.setItems(updatedCheckout.getItems());
        checkout.setOrderDate(updatedCheckout.getOrderDate());
        checkout.setTotalPrice(updatedCheckout.getTotalPrice());

        return checkoutRepository.save(checkout);
    }

    public Checkout checkout(Date orderDate, User buyer, List<Order> items) {
        Checkout checkout = new Checkout(orderDate, buyer, items);
        return checkoutRepository.save(checkout);
    }

    public void deleteCheckout(Long id) {
        checkoutRepository.deleteById(id);
    }
}
