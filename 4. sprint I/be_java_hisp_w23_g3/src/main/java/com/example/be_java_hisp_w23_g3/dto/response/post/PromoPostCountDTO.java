package com.example.be_java_hisp_w23_g3.dto.response.post;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PromoPostCountDTO {
    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("promo_products_count")
    private Integer promoProductsCount;

    public PromoPostCountDTO(Long userId, String userName, Integer promoProductsCount) {
        this.userId = userId;
        this.userName = userName;
        this.promoProductsCount = promoProductsCount;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getPromoProductsCount() {
        return promoProductsCount;
    }
}
