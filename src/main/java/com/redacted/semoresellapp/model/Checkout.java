package com.redacted.semoresellapp.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "checkout_table")
public class Checkout {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "order_date")
    private Date orderDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @OneToMany(mappedBy = "checkout", fetch = FetchType.LAZY)
    private List<Order> items;


    //Constructors
    public Checkout() {}

    public Checkout(Date orderDate, User buyer, List<Order> items) {
        this.orderDate = orderDate;
        this.buyer = buyer;
        this.items = items;

        this.totalPrice = items.stream().mapToDouble(Order::getPrice).sum();
    }

    //Methods


    //Getters and Setters
    public Long getId() {
        return id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public List<Order> getItems() {
        return items;
    }

    public void setItems(List<Order> items) {
        this.items = items;
    }


    //To-String, Equals, and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Checkout checkout = (Checkout) o;
        return Double.compare(checkout.totalPrice, totalPrice) == 0 && Objects.equals(id, checkout.id) && Objects.equals(orderDate, checkout.orderDate) && Objects.equals(buyer, checkout.buyer) && Objects.equals(items, checkout.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalPrice, orderDate, buyer, items);
    }
}
