package com.example.be_java_hisp_w23_g3.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class PromoPostCountDTO {
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("user_name")
    private String user_name;
    @JsonProperty("promo_products_count")
    private int promo_products_count;

    public PromoPostCountDTO(Long id, String username, int size) {
    }
}
