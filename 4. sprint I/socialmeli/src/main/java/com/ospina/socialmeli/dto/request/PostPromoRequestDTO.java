package com.ospina.socialmeli.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ospina.socialmeli.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostPromoRequestDTO {

    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("date")
    private String date;
    @JsonProperty("product")
    private ProductDTO product;
    @JsonProperty("category")
    private int category;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("has_promo")
    private Boolean hasPromo;
    @JsonProperty("discount")
    private Double discount;

}
