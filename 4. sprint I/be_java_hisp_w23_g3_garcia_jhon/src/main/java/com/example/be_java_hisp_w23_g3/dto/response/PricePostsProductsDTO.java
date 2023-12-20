package com.example.be_java_hisp_w23_g3.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PricePostsProductsDTO {

    @JsonProperty("user_id")
    private Long userID;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("price")
    private Double price;

}
