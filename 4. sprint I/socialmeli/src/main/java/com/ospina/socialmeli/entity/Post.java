package com.ospina.socialmeli.entity;

import com.ospina.socialmeli.util.ArgumentValidator;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Post {
    private Long id;
    private Seller seller;
    private Product product;
    private LocalDate date;
    private int category;
    private Double price;
    private boolean hasDiscount = false;
    private Double discount;

    private Post(Long id, Seller seller, Product product, LocalDate date, int category, Double price) {
        this.id = id;
        this.seller = seller;
        this.product = product;
        this.date = date;
        this.category = category;
        this.price = price;
    }

    public Post(Long id, Seller seller, Product product, LocalDate date, int category, Double price, boolean hasDiscount, Double discount) {
        this.id = id;
        this.seller = seller;
        this.product = product;
        this.date = date;
        this.category = category;
        this.price = price;
        this.hasDiscount = hasDiscount;
        this.discount = discount;
    }

    public static Post build(Long id, Seller seller, Product product, LocalDate date, int category, Double price) {
        validatePost(id, seller, product, date, category, price);

        return new Post(id, seller, product, date, category, price);
    }

    public static Post build(Long id, Seller seller, Product product, LocalDate date, int category, Double price, boolean hasDiscount, Double discount) {
        validatePost(id, seller, product, date, category, price);
        ArgumentValidator.validateRequired(hasDiscount, "hasDiscount is required");
        ArgumentValidator.validateRequired(discount, "discount is required");
        ArgumentValidator.validatePositive(discount, "discount must be positive");
        return new Post(id, seller, product, date, category, price, hasDiscount, discount);
    }

    private static void validatePost(Long id, Seller seller, Product product, LocalDate date, int category, Double price) {
        ArgumentValidator.validateRequired(id, "Id is required");
        ArgumentValidator.validatePositive(id, "Id is required");
        ArgumentValidator.validateRequired(seller, "Seller is required");
        ArgumentValidator.validateRequired(product, "Product is required");
        ArgumentValidator.validateRequired(date, "Date is required");
        ArgumentValidator.validateRequired(category, "Category is required");
        ArgumentValidator.validatePositive(category, "Category is required");
        ArgumentValidator.validateRequired(price, "Price is required");
        ArgumentValidator.validatePositive(price, "Price must be positive");
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

    public boolean isHasDiscount() {
        return hasDiscount;
    }

    public void setHasDiscount(boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
