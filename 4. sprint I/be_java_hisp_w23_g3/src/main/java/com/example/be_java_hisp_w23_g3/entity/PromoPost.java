package com.example.be_java_hisp_w23_g3.entity;

import com.example.be_java_hisp_w23_g3.util.ArgumentValidator;

import java.time.LocalDate;

public class PromoPost extends Post {

    private boolean hasPromo;
    private Double discount;
    protected PromoPost(Seller seller, Product product, LocalDate date, int category, Double price, boolean hasPromo, Double discount) {
        super(seller, product, date, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public static PromoPost build(Post post, boolean hasPromo, Double discount) {
        ArgumentValidator.validateRequired(hasPromo, "HasPromo is required");
        ArgumentValidator.validateRequired(discount, "Discount is required");
        return new PromoPost(post.getSeller(), post.getProduct(), post.getDate(),
                post.getCategory(), post.getPrice(), hasPromo, discount);
    }

    public boolean isHasPromo() {
        return hasPromo;
    }

    public Double getDiscount() {
        return discount;
    }
}
