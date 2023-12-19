package com.sprint.be_java_hisp_w23_g04.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PostPromo extends Post {
    private boolean hasPromo;
    private double discount;

    public PostPromo(int id, LocalDate date, Product product, int category, double price, boolean hasPromo, double discount) {
        super(id, date, product, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}