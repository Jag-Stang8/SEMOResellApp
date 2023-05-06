package com.redacted.semoresellapp.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "review_table")
public class Review {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "rating")
    private int rating;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id", nullable = false)
    private User buyer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;


    //Constructors
    public Review() {}

    public Review(int rating, String content, Listing listing, User buyer, User seller) {
        this.rating = rating;
        this.content = content;
        this.listing = listing;
        this.buyer = buyer;
        this.seller = seller;
    }


    //Methods



    //Getters and Setters
    public Long getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Listing getListing() {
        return listing;
    }

    public User getUser() {
        return buyer;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }


    //To-String, Equals, and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return rating == review.rating && Objects.equals(id, review.id) && Objects.equals(content, review.content) && Objects.equals(listing, review.listing) && Objects.equals(buyer, review.buyer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rating, content, listing, buyer);
    }
}
