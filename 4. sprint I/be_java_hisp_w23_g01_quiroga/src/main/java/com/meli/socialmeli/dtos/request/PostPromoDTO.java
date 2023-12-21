package com.meli.socialmeli.dtos.request;

import com.meli.socialmeli.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoDTO extends PostDTO{
    private boolean has_promo;
    private double discount;

}
