package com.redacted.semoresellapp.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "order_table")
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
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "checkout_id", nullable = false)
    private Checkout checkout;


    //Constructors
    public Order() {}

    public Order(int quantity, double price, String status, User buyer, User seller, Listing listing, Checkout checkout) {
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.buyer = buyer;
        this.seller = seller;
        this.listing = listing;
        this.checkout = checkout;
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

    public User getSeller() {
        return this.seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Listing getListing() {
        return listing;
    }

    public Checkout getCheckout() {
        return checkout;
    }

    public void setCheckout(Checkout checkout) {
        this.checkout = checkout;
    }


    //To-String, Equals, and HashCode
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", listing=" + listing +
                ", checkout=" + checkout +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return quantity == order.quantity && Double.compare(order.price, price) == 0 && Objects.equals(id, order.id) && Objects.equals(status, order.status) && Objects.equals(buyer, order.buyer) && Objects.equals(seller, order.seller) && Objects.equals(listing, order.listing) && Objects.equals(checkout, order.checkout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, price, status, buyer, seller, listing, checkout);
    }
}
