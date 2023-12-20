package com.meli.socialmeli.dtos.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostDTO extends PostDTO {
    private boolean has_promo;
    private double discount;
}
