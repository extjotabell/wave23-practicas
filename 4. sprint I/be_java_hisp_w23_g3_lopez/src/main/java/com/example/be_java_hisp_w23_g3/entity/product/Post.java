package com.example.be_java_hisp_w23_g3.entity.product;

import com.example.be_java_hisp_w23_g3.entity.user.Seller;
import com.example.be_java_hisp_w23_g3.util.Validator;

import java.time.LocalDate;

public class Post {
    private Long id;
    private Seller seller;
    private Product product;
    private LocalDate date;
    private int category;
    private Double price;
    private boolean hasPromo;
    private Double discount;

    private Post(Long id, Seller seller, Product product, LocalDate date, int category, Double price) {
        this.id = id;
        this.seller = seller;
        this.product = product;
        this.date = date;
        this.category = category;
        this.price = price;
    }

    public Post(Long id, Seller seller, Product product, LocalDate date, int category, Double price, boolean hasPromo, Double discount) {
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
        Validator.validateRequired(id, "Id is required");
        Validator.validatePositive(id, "Id is required");
        Validator.validateRequired(seller, "Seller is required");
        Validator.validateRequired(product, "Product is required");
        Validator.validateRequired(date, "Date is required");
        Validator.validateRequired(category, "Category is required");
        Validator.validatePositive(category, "Category is required");
        Validator.validateRequired(price, "Price is required");
        Validator.validatePositive(price, "Price is required");
        return new Post(id, seller, product, date, category, price);
    }

    public static Post build(Long id, Seller seller, Product product, LocalDate date, int category, Double price, boolean hasPromo, Double discount) {
        Validator.validateRequired(id, "Id is required");
        Validator.validatePositive(id, "Id is required");
        Validator.validateRequired(seller, "Seller is required");
        Validator.validateRequired(product, "Product is required");
        Validator.validateRequired(date, "Date is required");
        Validator.validateRequired(category, "Category is required");
        Validator.validatePositive(category, "Category is required");
        Validator.validateRequired(price, "Price is required");
        Validator.validatePositive(price, "Price is required");
        Validator.validateRequired(hasPromo, "Has Promo is required");
        Validator.validateRequired(discount, "Discount is required");
        Validator.validatePositive(discount, "Discount is required");
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

    public boolean isHasPromo() {
        return hasPromo;
    }

    public Double getDiscount() {
        return discount;
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

    public void setHasPromo(boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
