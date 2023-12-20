package com.example.be_java_hisp_w23_g3.dto.response.post;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class ResponsePromoPostDTO extends ResponsePostDTO {

    @JsonProperty("has_promo")
    private boolean hasPromo;
    private Double discount;
    public ResponsePromoPostDTO(Long userId, String postId, LocalDate date, ResponseProductDTO product,
                                int category, Double price, boolean hasPromo, Double discount) {
        super(userId, postId, date, product, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public boolean isHasPromo() {
        return hasPromo;
    }

    public Double getDiscount() {
        return discount;
    }
}
