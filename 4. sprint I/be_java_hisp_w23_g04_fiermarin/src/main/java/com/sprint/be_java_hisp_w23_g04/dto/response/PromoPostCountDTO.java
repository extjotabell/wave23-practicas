package com.sprint.be_java_hisp_w23_g04.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromoPostCountDTO {
    private int user_id;
    private String user_name;
    private int promo_products_count;
}
