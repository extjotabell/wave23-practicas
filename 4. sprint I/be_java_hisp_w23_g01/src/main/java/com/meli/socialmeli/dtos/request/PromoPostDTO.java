package com.meli.socialmeli.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.socialmeli.dtos.response.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PromoPostDTO {
    @JsonProperty("user_id")
    private int userId;
    private LocalDate date;
    private ProductDTO product;
    private int category;
    private double price;
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;
}
