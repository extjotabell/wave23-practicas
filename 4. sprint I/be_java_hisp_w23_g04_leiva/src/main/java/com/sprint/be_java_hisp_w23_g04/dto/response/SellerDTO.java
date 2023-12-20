package com.sprint.be_java_hisp_w23_g04.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sprint.be_java_hisp_w23_g04.dto.request.PostPromoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"user_id", "user_name", "product"})
public class SellerDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String name;
    private PostPromoDTO product;
}
