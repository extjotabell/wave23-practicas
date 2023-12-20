package com.meli.socialmeli.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CountPostPromoDTO {
    int user_id;
    String user_name;
    long promo_products_count;
}