package com.redacted.semoresellapp.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems = new ArrayList<>();

    private double totalPrice = 0;

    private Integer totalQuantity = 0;

    // Constructor, getters, and setters
    // ...

    public void addCartItem(Listing listing) {
        for (CartItem item : cartItems) {
            if (item.getListing().getListingID().equals(listing.getListingID())) {
                item.setQuantity(item.getQuantity() + 1);
                updateCart();
                return;
            }
        }
        CartItem newItem = new CartItem(listing, this);
        cartItems.add(newItem);
        updateCart();
    }

    public void removeCartItem(CartItem item) {
        cartItems.remove(item);
        updateCart();
    }

    public void updateCart() {
        totalPrice = 0;
        totalQuantity = 0;
        for (CartItem item : cartItems) {
            totalPrice = totalPrice += item.getPrice();
            totalQuantity += item.getQuantity();
        }
    }

    public void clearCart() {
        cartItems.clear();
        updateCart();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public CartItem getItemByListing(Listing listing) {
        return cartItems.get(cartItems.indexOf(listing));
    }
}
