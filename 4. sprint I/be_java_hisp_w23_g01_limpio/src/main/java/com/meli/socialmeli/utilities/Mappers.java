package com.meli.socialmeli.utilities;

import com.meli.socialmeli.dtos.request.PostDTO;
import com.meli.socialmeli.dtos.request.PromoPostDTO;
import com.meli.socialmeli.dtos.response.ProductDTO;
import com.meli.socialmeli.entities.Post;
import com.meli.socialmeli.entities.Product;

public class Mappers {

    public static Product mapProduct(ProductDTO productDTO){
        return new Product(productDTO.getProduct_id(), productDTO.getProduct_name(), productDTO.getType(), productDTO.getBrand(), productDTO.getColor(), productDTO.getNotes());

    }
    public static Post mapNewPost(PostDTO post, int post_id){
        return new Post(post.getDate(), mapProduct(post.getProduct()), post.getCategory(), post.getPrice(), post_id);
    }

    public static Post mapNewPromoPost(PromoPostDTO post, int post_id){
        Post newPost = new Post(post.getDate(), mapProduct(post.getProduct()), post.getCategory(), post.getPrice(), post_id);
        newPost.setHas_promo(post.isHas_promo());
        newPost.setDiscount(post.getDiscount());
        return newPost;
    }
    public static Product mapProductDtoToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setProduct_id(productDTO.getProduct_id());
        product.setProduct_name(productDTO.getProduct_name());
        product.setType(productDTO.getType());
        product.setBrand(productDTO.getBrand());
        product.setColor(productDTO.getColor());
        product.setNotes(productDTO.getNotes());
        return product;
    }
}
