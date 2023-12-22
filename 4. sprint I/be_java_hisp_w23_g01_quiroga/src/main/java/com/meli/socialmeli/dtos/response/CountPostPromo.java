package com.meli.socialmeli.dtos.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountPostPromo {

    private int user_id;
    private String user_name;
    private  int promo_products_count;

}
