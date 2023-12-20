package com.example.be_java_hisp_w23_g3.dto.request.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class RequestPromoPostDTO extends RequestPostDTO {

    @JsonProperty("has_promo")
    @NotNull
    private boolean hasPromo;
    @NotNull
    private Double discount;

    public RequestPromoPostDTO(Long userId, LocalDate date, RequestProductDTO product, int category,
                               Double price, boolean hasPromo, Double discount) {
        super(userId, date, product, category, price);
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
