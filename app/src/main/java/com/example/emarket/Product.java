package com.example.emarket;

public class Product {
    public String id, name, price, description, imageUrl;

    public Product() {}

    public Product(String id, String name, String price, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}