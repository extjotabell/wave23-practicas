package com.meli.socialmeli.utilities;

import com.meli.socialmeli.dtos.request.PostDTO;
import com.meli.socialmeli.dtos.request.PostPromoDTO;
import com.meli.socialmeli.dtos.response.ProductDTO;
import com.meli.socialmeli.entities.Post;
import com.meli.socialmeli.entities.Product;

import java.time.LocalDate;

public class Mappers {

    public static Product mapProduct(ProductDTO productDTO){
        return new Product(productDTO.getProduct_id(), productDTO.getProduct_name(), productDTO.getType(), productDTO.getBrand(), productDTO.getColor(), productDTO.getNotes());

    }
    public static Post mapNewPost(PostDTO post, int post_id){
        return new Post(post.getDate(), mapProduct(post.getProduct()), post.getCategory(), post.getPrice(), post_id);
    }

    public static Post mapNewPostPromo(PostPromoDTO post, int post_id){
        return new Post(
                post_id,
                post.getDate(),
                post.getCategory(),
                post.getPrice(),
                post.isHas_promo(),
                post.getDiscount(),
                mapProduct(post.getProduct())
        );
    }
}
