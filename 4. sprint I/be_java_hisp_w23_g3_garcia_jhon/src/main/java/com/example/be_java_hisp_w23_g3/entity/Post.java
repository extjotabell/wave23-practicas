package com.example.be_java_hisp_w23_g3.entity;

import com.example.be_java_hisp_w23_g3.util.ArgumentValidator;

import javax.swing.event.DocumentEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Post {
    private Long id;
    private Seller seller;
    private Product product;
    private LocalDate date;
    private int category;
    private Double price;
    private Boolean hasPromo = false;
    private Double discount = 0.0;

    private Post(Long id, Seller seller, Product product, LocalDate date, int category, Double price) {
        this.id = id;
        this.seller = seller;
        this.product = product;
        this.date = date;
        this.category = category;
        this.price = price;
    }

    private Post(Long id, Seller seller, Product product, LocalDate date, int category, Double price, Boolean hasPromo, Double discount) {
        this.id = id;
        this.seller = seller;
        this.product = product;
        this.date = date;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public static Post build(Long id, Seller seller, Product product, LocalDate date, int category, Double price) {
        ArgumentValidator.validateRequired(id, "Id is required");
        ArgumentValidator.validatePositive(id, "Id is required");
        ArgumentValidator.validateRequired(seller, "Seller is required");
        ArgumentValidator.validateRequired(product, "Product is required");
        ArgumentValidator.validateRequired(date, "Date is required");
        ArgumentValidator.validateRequired(category, "Category is required");
        ArgumentValidator.validatePositive(category, "Category is required");
        ArgumentValidator.validateRequired(price, "Price is required");
        ArgumentValidator.validatePositive(price, "Price is required");
        return new Post(id, seller, product, date, category, price);
    }

    public static Post build(Long id, Seller seller, Product product, LocalDate date, int category, Double price, Boolean hasPromo, Double discount) {
        ArgumentValidator.validateRequired(id, "Id is required");
        ArgumentValidator.validatePositive(id, "Id is required");
        ArgumentValidator.validateRequired(seller, "Seller is required");
        ArgumentValidator.validateRequired(product, "Product is required");
        ArgumentValidator.validateRequired(date, "Date is required");
        ArgumentValidator.validateRequired(category, "Category is required");
        ArgumentValidator.validatePositive(category, "Category is required");
        ArgumentValidator.validateRequired(price, "Price is required");
        ArgumentValidator.validatePositive(price, "Price is required");
        ArgumentValidator.validateRequired(hasPromo, "HasPromo is required");
        ArgumentValidator.validateRequired(discount, "Discount is required");
        ArgumentValidator.validatePositive(discount, "Discount is required");
        return new Post(id, seller, product, date, category, price, hasPromo, discount);
    }

    public Long getId() {
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

    public Boolean getHasPromo() { return hasPromo; }

    public void setHasPromo(Boolean hasPromo) { this.hasPromo = hasPromo; }

    public Double getDiscount() { return discount; }

    public void setDiscount(Double discount) { this.discount = discount; }
}
