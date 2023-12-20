package com.sprint.be_java_hisp_w23_g04.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PromoPostsCountDTO {
        @JsonProperty("user_id")
        private Integer userId;
        @JsonProperty("user_name")
        private String userName;
        @JsonProperty("promo_products_count")
        private Integer promoProductsCount;
}
