package com.sprint.be_java_hisp_w23_g04.dto.request;

import com.sprint.be_java_hisp_w23_g04.dto.response.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostDTO extends PostDTO{
    private boolean has_promo;
    private double discount;

    public PromoPostDTO(int userId, LocalDate date, ProductDTO product, int category, double price, Boolean has_promo, Double discount) {
        super(userId, date, product, category, price);
        this.has_promo = has_promo;
        this.discount = discount;
    }
}