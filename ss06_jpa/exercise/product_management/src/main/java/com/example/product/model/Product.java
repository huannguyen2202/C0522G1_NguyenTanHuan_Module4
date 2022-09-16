package com.example.product.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private int id;
    private String productName;
    private int productPrice;
    private String description;
    private String producer;

    public Product() {
    }

    public Product(int id, String productName, int productPrice, String description, String producer) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.description = description;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
