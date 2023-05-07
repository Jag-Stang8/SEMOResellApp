package com.redacted.semoresellapp.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cart_table")
public class Cart {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "status")
    private String status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany
    @JoinTable(name = "cart_listing", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "listing_id"))
    private List<Listing> items;


    //Constructors
    public Cart() {}

    public Cart(int quantity, String status, User user, List<Listing> items) {
        this.quantity = quantity;
        this.status = status;
        this.user = user;
        this.items = items;
    }


    //Methods



    //Getters and Setters
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public User getUser() {
        return user;
    }

    public List<Listing> getItems() {
        return items;
    }

    public void setItems(List<Listing> items) {
        this.items = items;
    }

    //To-String, Equals, and HashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return quantity == cart.quantity && Objects.equals(id, cart.id) && Objects.equals(status, cart.status) && Objects.equals(user, cart.user) && Objects.equals(items, cart.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, status, user, items);
    }
}
