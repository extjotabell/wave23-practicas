package com.sprint.be_java_hisp_w23_g04.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromoPost extends Post{
    private boolean hasPromo;
    private double discount;

    public PromoPost(int id, LocalDate date, Product product, int category, double price, boolean hasPromo, double discount){
        super(id, date, product, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
