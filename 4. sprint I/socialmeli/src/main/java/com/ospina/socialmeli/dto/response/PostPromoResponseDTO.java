package com.ospina.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ospina.socialmeli.dto.ProductDTO;
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
    private ProductDTO product;
    @JsonProperty("category")
    private int category;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("hasPromo")
    private Boolean hasPromo;
    @JsonProperty("discount")
    private Double discount;

}
