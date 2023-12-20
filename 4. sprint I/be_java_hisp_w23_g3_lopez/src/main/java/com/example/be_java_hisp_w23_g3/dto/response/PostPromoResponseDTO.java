package com.example.be_java_hisp_w23_g3.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostPromoResponseDTO {

    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("post_id")
    private Long postId;
    @JsonProperty("date")
    private LocalDate date;
    @JsonProperty("product")
    private ProductResponseDTO product;
    @JsonProperty("category")
    private int category;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("has_promo")
    private boolean hasPromo;
    @JsonProperty("discount")
    private Double discount;

}
