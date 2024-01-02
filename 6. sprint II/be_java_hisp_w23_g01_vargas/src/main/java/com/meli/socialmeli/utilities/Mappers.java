package com.meli.socialmeli.utilities;

import com.meli.socialmeli.dtos.request.PostDTO;
import com.meli.socialmeli.dtos.response.PostNoPromoDTO;
import com.meli.socialmeli.dtos.response.ProductDTO;
import com.meli.socialmeli.entities.Post;
import com.meli.socialmeli.entities.Product;
import com.meli.socialmeli.entities.User;

public class Mappers {

    public static Product mapProduct(ProductDTO productDTO){
        return new Product(productDTO.getProduct_id(), productDTO.getProduct_name(), productDTO.getType(), productDTO.getBrand(), productDTO.getColor(), productDTO.getNotes());

    }
    public static Post mapNewPost(PostDTO post, int post_id){
        return new Post(post.getDate(), mapProduct(post.getProduct()), post.getCategory(), post.getPrice(), post_id);
    }

    public static ProductDTO mapProductProductDTO(Product product){
        return new ProductDTO(
                product.getProduct_id(),
                product.getProduct_name(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes()
        );
    }

    public static PostNoPromoDTO mapPostUserAndProductPromoNoPromoDTO(Post post, User user) {
        return new PostNoPromoDTO(
                user.getUser_id(),
                post.getPost_id(),
                post.getDate().toString(),
                mapProductProductDTO(post.getProduct()),
                post.getCategory(),
                post.getPrice()
        );
    }
}
