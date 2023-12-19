package com.sprint.be_java_hisp_w23_g04.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sprint.be_java_hisp_w23_g04.dto.response.ProductDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PostPromoDTO extends PostDTO {
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;

    public PostPromoDTO(int userId, LocalDate date, ProductDTO product, int category, double price, boolean hasPromo, double discount) {
        super(userId, date, product, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
