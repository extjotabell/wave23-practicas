package com.mercadolibre.be_java_hisp_w23_g2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PromoProductCountDTO {
    int user_id;
    String user_name;
    int promo_product_counts;
}
