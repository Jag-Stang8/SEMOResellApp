package com.redacted.semoresellapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
/*
 * This class implements the Review entity with the attributes:
 * reviewID, content, sellRate, and buyRate
 * as well as the appropriate getters and setters
 */
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewID;

    private String content;
    private double sellRate;
    private double buyRate;

    public Review() {};

    public Review(String content, double sellRate, double buyRate) {
        this.content = content;
        this.sellRate = sellRate;
        this.buyRate = buyRate;
    }

    public void setReviewID(Long reviewID) {
        this.reviewID = reviewID;
    }

    public Long getReviewID() {
        return reviewID;
    }

    public String getContent() {
        return this.content;
    }
}
