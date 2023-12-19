package com.ospina.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PromoCountResponseDTO {

    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("promo_products_count")
    private Long promoProductsCount;

    public PromoCountResponseDTO(Long userId, String userName, Long promoProductsCount) {
        this.userId = userId;
        this.userName = userName;
        this.promoProductsCount = promoProductsCount;
    }
}
