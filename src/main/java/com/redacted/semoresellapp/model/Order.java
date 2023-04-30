package com.redacted.semoresellapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    private Long customerId;
    private Long listingId;
    private LocalDate orderDate;

    public Order(Long id, Long customerId, Long listingId, LocalDate orderDate) {
        this.id = id;
        this.customerId = customerId;
        this.listingId = listingId;
        this.orderDate = orderDate;
    }

    public Order() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
