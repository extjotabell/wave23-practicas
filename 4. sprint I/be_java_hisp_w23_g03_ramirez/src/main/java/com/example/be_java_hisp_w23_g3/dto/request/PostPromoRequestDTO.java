package com.example.be_java_hisp_w23_g3.dto.request;

import com.example.be_java_hisp_w23_g3.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    private boolean hasPromo;
    @JsonProperty("discount")
    private Double discount;
}
