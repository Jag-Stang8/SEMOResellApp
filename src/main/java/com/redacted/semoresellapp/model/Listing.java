package com.redacted.semoresellapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "listing_table")
public class Listing {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "desc")
    private String desc;

    @Column(name = "image")
    private String image;

    @Column(name = "price")
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;


    //Constructors
    public Listing() {}

    public Listing(String title, String desc, String image, double price, User seller) {
        this.title = title;
        this.desc = desc;
        this.image = image;
        this.price = price;
        this.seller = seller;
    }

    //Methods


    //Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getSeller() {
        return this.seller;
    }


    //To-String

    @Override
    public String toString() {
        return "Listing{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", seller=" + seller +
                '}';
    }
}

