package com.redacted.semoresellapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
/*
 * This class implements the Customer entity with the attributes:
 * userID, email, password, buyRate, and sellRate
 * as well as the appropriate getters and setters
 */
public class Customer {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    private String email;
    private char[] password;
    private double buyRate;
    private double sellRate;

    public Customer(){}

    public Customer(String email, char[] password, double buyRate, double sellRate){
        this.email = email;
        this.password = password;
        this.buyRate = buyRate;
        this.sellRate = sellRate;
    }


    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getUserID() {
        return userID;
    }

    public double getSellRate() {
        return sellRate;
    }

    public void setSellRate(double sellRate) {
        this.sellRate = sellRate;
    }

    public double getBuyRate() {
        return buyRate;
    }

    public void setBuyRate(double buyRate) {
        this.buyRate = buyRate;
    }

    public String getEmail() {
        return email;
    }
}
