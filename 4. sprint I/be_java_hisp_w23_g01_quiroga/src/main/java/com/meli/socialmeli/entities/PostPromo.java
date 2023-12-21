package com.meli.socialmeli.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostPromo extends Post{

    protected boolean has_promo;
    protected double discount;

    public PostPromo(int post_id, LocalDate date, Product product, Integer category, double price, boolean has_promo, double discount){
        super(date, product, category, price, post_id);
        this.has_promo = has_promo;
        this.discount = discount;
    }
}
