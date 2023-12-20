package com.example.be_java_hisp_w23_g3.dto.response;

import com.example.be_java_hisp_w23_g3.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PromoDTO {
    @JsonProperty("product")
    private ProductDTO product;
    @JsonProperty("seller")
    private String seller_name;
}
