package com.redacted.semoresellapp.service;

import com.redacted.semoresellapp.exception.CartNotFoundException;
import com.redacted.semoresellapp.model.Cart;
import com.redacted.semoresellapp.model.Listing;
import com.redacted.semoresellapp.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getAllCarts() {
        return (List<Cart>) cartRepository.findAll();
    }

    public Cart getCartById(Long id) {
        Optional<Cart> optionalCart = cartRepository.findById(id);
        if(optionalCart.isPresent())
            return optionalCart.get();
        else
            throw new CartNotFoundException("No Listing with id: " + id + " found");
    }

    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart updateCart(Long id, Cart updatedCart) {
        Cart cart = getCartById(id);
        cart.setQuantity(updatedCart.getQuantity());
        cart.setStatus(updatedCart.getStatus());
        cart.setItems(updatedCart.getItems());

        return cartRepository.save(cart);
    }

    public void addItemToCart(Cart cart, Listing listing) {
        List<Listing> items = cart.getItems();
        items.add(listing);
        cart.setItems(items);
        cartRepository.save(cart);
    }

    public void removeItemFromCart(Cart cart, Listing listing) {
        List<Listing> items = cart.getItems();
        items.remove(listing);
        cart.setItems(items);
        cartRepository.save(cart);
    }

    public void clearCart(Cart cart) {
        cart.setItems(new ArrayList<>());
        cartRepository.save(cart);
    }

    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }
}
