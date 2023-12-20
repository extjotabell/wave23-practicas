package com.example.be_java_hisp_w23_g3.dto.request;

import com.example.be_java_hisp_w23_g3.dto.response.ProductResponseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostRequestDTO {

    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("date")
    private String date;
    @JsonProperty("product")
    private ProductResponseDTO product;
    @JsonProperty("category")
    private int category;
    @JsonProperty("price")
    private Double price;

}
