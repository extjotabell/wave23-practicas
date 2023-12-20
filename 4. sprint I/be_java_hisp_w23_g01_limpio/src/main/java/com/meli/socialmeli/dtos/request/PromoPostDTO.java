package com.meli.socialmeli.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.socialmeli.dtos.response.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromoPostDTO extends PostDTO{

    protected boolean has_promo;
    protected double discount;


}
