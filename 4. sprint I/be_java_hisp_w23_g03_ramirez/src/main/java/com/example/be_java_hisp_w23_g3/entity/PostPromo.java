package com.example.be_java_hisp_w23_g3.entity;

import com.example.be_java_hisp_w23_g3.util.ArgumentValidator;

import java.time.LocalDate;

public class PostPromo extends Post{
    private boolean hasPromo;

    private Double discount;

    private PostPromo(Long id, Seller seller, Product product, LocalDate date, int category, Double price,Double discount) {
        super(id, seller, product, date, category, price);
        this.hasPromo = true;
        this.discount = discount;
    }

    public static PostPromo build(Post post, Double discount){
        ArgumentValidator.validateRequired(discount, "Discount is required");
        ArgumentValidator.validatePositive(discount, "Discount is required");
        return new PostPromo(post.getId(), post.getSeller(),post.getProduct(),post.getDate(),post.getCategory(),post.getPrice(),discount);
    }
}
