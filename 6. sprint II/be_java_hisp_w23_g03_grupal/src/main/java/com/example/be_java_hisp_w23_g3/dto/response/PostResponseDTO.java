package com.example.be_java_hisp_w23_g3.dto.response;

import com.example.be_java_hisp_w23_g3.dto.request.ProductDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class PostResponseDTO {

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

}
