package com.meli.socialmeli.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int post_id;
    private LocalDate date;
    private Integer category;
    private double price;
    private boolean has_promo;
    private double discount;
    private Product product;

    public Post(int postId, LocalDate date, int category, double price, boolean has_promo, double discount, Product product){
        this.post_id = postId;
        this.date = date;
        this.category = category;
        this.price = price;
        this.has_promo = has_promo;
        this.discount = discount;
        this.product = product;
    }

    public Post(LocalDate date, Product product, int category, double price, int post_id) {
        this.post_id = post_id;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }
}
