package com.meli.socialmeli.dtos.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CountPostPromoDTO {

    private int user_id;
    private String user_name;
    private  int promo_products_count;

}
