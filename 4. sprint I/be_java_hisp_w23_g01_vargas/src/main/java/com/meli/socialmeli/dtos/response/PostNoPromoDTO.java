package com.meli.socialmeli.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostNoPromoDTO {
    private Integer user_id;
    private Integer post_id;
    private String date;
    private ProductDTO product;
    private Integer category;
    private Double price;
}