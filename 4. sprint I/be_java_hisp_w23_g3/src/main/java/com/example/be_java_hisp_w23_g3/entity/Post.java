package com.example.be_java_hisp_w23_g3.entity;

import com.example.be_java_hisp_w23_g3.util.ArgumentValidator;

import java.time.LocalDate;
import java.util.UUID;

public class Post {
    private final String id;
    private Seller seller;
    private Product product;
    private LocalDate date;
    private int category;
    private Double price;

    protected Post(Seller seller, Product product, LocalDate date, int category, Double price) {
        this.id = UUID.randomUUID().toString();
        this.seller = seller;
        this.product = product;
        this.date = date;
        this.category = category;
        this.price = price;
    }

    public static Post build(Seller seller, Product product, LocalDate date, int category, Double price) {
        ArgumentValidator.validateRequired(seller, "Seller is required");
        ArgumentValidator.validateRequired(product, "Product is required");
        ArgumentValidator.validateRequired(date, "Date is required");
        ArgumentValidator.validateRequired(category, "Category is required");
        ArgumentValidator.validateRequired(price, "Price is required");
        return new Post(seller, product, date, category, price);
    }

    public String getId() {
        return id;
    }

    public Seller getSeller() {
        return seller;
    }

    public Product getProduct() {
        return product;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
