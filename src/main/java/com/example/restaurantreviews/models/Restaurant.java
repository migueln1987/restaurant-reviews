package com.example.restaurantreviews.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Restaurant")
public class Restaurant {

    @Id
    private String id;
    private String name;
    private Address address;
    private List<Review> reviews;

    public Restaurant() {
    }

    public Restaurant(String name, Address address, List<Review> reviews) {
        this.name = name;
        this.address = address;
        this.reviews = reviews;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
