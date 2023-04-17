package com.redacted.semoresellapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
/*
 * This class implements the Listing entity with the attributes:
 * listingID, itemName, itemDesc, price, and categoriesList
 * as well as the appropriate getters and setters
 */
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long listingID;

    private String itemName;
    private String itemDesc;
    private double price;
    private List<Categories> categoriesList;

    public Listing() {}


    public Listing(String itemName, String itemDesc, double price, List<Categories> categoriesList) {
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.price = price;
        this.categoriesList = categoriesList;
    }

    public void setListingID(Long listingID) {
        this.listingID = listingID;
    }

    public Long getListingID() {
        return listingID;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public double getPrice() {
        return price;
    }

    public List<Categories> getCategoriesList() {
        return categoriesList;
    }
}
