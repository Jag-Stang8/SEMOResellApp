package com.redacted.semoresellapp.model;

import jakarta.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    private Listing listing;

    private int quantity;

    private double price;

    public OrderItem() {}

    public OrderItem(Listing listing, int quantity, double price) {
        this.listing = listing;
        this.quantity = quantity;
        this.price = price;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Listing getListing() {
        return listing;
    }

    public void setBook(Listing listing) {
        this.listing = listing;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // methods

    public void increaseQuantity() {
        this.quantity++;
    }

    public void decreaseQuantity() {
        this.quantity--;
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}

