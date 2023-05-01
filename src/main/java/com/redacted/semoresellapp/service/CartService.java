package com.redacted.semoresellapp.service;

import com.redacted.semoresellapp.model.*;
import com.redacted.semoresellapp.repository.ListingRepository;
import com.redacted.semoresellapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {
    private ListingRepository listingRepository;
    private OrderRepository orderRepository;

    public CartService(ListingRepository listingRepository, OrderRepository orderRepository) {
        this.listingRepository = listingRepository;
        this.orderRepository = orderRepository;
    }

    public void addItemToCart(Cart cart, Listing listing, int quantity) {
        CartItem cartItem = cart.getItemByListing(listing);
        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        } else {
            cart.getCartItems().add(new CartItem(listing, quantity));
        }
    }

    public void updateCartItemQuantity(Cart cart, Listing listing, int quantity) {
        CartItem cartItem = cart.getItemByListing(listing);
        if (cartItem != null) {
            cartItem.setQuantity(quantity);
        }
    }

    public void removeItemFromCart(Cart cart, Listing listing) {
        CartItem cartItem = cart.getItemByListing(listing);
        if (cartItem != null) {
            cart.getCartItems().remove(cartItem);
        }
    }

    public void checkoutCart(Cart cart, Customer customer) {
        List<OrderItem> orderItems = cart.getCartItems().stream()
                .map(item -> new OrderItem(item.getListing(), item.getQuantity(), item.getPrice()))
                .collect(Collectors.toList());

        Order order = new Order(customer, orderItems);
        for (CartItem cartItem : cart.getCartItems()) {
            Listing listing = cartItem.getListing();
            listingRepository.save(listing);
        }
        cart.getCartItems().clear();
        orderRepository.save(order);
    }
}
