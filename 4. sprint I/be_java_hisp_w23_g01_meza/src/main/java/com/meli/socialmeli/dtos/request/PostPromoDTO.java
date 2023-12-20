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
public class PostPromoDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty(required = true)
    private LocalDate date;
    @JsonProperty(required = true)
    private ProductDTO product;
    @JsonProperty(required = true)
    private int category;
    @JsonProperty(required = true)
    private double price;
    @JsonProperty(required = true)
    private boolean has_promo;
    @JsonProperty(required = true)
    private double discount;
}

