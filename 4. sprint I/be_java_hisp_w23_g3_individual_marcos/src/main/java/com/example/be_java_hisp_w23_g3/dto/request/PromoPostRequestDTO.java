package com.example.be_java_hisp_w23_g3.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PromoPostRequestDTO extends PostRequestDTO{

    @JsonProperty("has_promo")
    private Boolean hasPromo;
    @JsonProperty("discount")
    private Double discount;
}
