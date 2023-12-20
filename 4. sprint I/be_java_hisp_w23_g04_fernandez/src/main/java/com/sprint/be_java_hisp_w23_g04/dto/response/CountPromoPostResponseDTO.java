package com.sprint.be_java_hisp_w23_g04.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CountPromoPostResponseDTO{
    @JsonProperty("user_id")
    int userId;
    @JsonProperty("user_name")
    String userName;
    @JsonProperty("promo_products_count")
    long promoProductsCount;
}

