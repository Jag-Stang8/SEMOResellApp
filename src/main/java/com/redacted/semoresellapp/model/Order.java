package com.redacted.semoresellapp.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Order {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "status")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id", nullable = false)
    private User buyer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing;


    //Constructors
    public Order() {}

    public Order(int quantity, double price, String status, User buyer, Listing listing) {
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.buyer = buyer;
        this.listing = listing;
    }


    //Methods


    //Getters and Setters
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public User getBuyer() {
        return buyer;
    }

    public Listing getListing() {
        return listing;
    }


    //To-String, Equals, and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return quantity == order.quantity && Double.compare(order.price, price) == 0 && Objects.equals(id, order.id) && Objects.equals(status, order.status) && Objects.equals(buyer, order.buyer) && Objects.equals(listing, order.listing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, price, status, buyer, listing);
    }
}
