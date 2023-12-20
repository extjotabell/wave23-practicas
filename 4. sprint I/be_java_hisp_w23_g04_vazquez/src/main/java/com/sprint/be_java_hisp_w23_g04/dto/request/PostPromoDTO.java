package com.sprint.be_java_hisp_w23_g04.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostPromoDTO extends PostDTO {
    @JsonProperty("has_promo")
    protected boolean hasPromo;
    protected double discount;

}
