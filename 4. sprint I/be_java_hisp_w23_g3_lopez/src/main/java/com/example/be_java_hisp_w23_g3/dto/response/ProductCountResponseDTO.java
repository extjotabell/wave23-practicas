package com.example.be_java_hisp_w23_g3.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductCountResponseDTO {
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("promo_products_count")
    private int promoProductsCount;
}
