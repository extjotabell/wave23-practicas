package com.example.be_java_hisp_w23_g3.dto.response;

import com.example.be_java_hisp_w23_g3.dto.ProductDTO;
import com.example.be_java_hisp_w23_g3.dto.request.PostRequestDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostPromoResponseDTO extends PostResponseDTO {

    @JsonProperty("has_promo")
    private Boolean hasPromo;
    @JsonProperty("discount")
    private Double discount;

    public PostPromoResponseDTO(Long id, Long id1, LocalDate date, ProductDTO productDTO, int category, Double price, Boolean hasPromo, Double discount) {
        super(id, id1, date, productDTO, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
