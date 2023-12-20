package com.example.be_java_hisp_w23_g3.util;

import com.example.be_java_hisp_w23_g3.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w23_g3.dto.response.PostPromoCountDTO;
import com.example.be_java_hisp_w23_g3.dto.response.PostsPromoListResponseDTO;
import com.example.be_java_hisp_w23_g3.dto.response.PricePostsProductsDTO;
import com.example.be_java_hisp_w23_g3.entity.Seller;

import java.util.stream.Collectors;

public class DTOMapper {
    public static FollowersCountDTO mapToFollowersCountDTO(Seller seller) {
        return new FollowersCountDTO(seller.getId(), seller.getUsername(), seller.getFollower().size());
    }

    public static PostPromoCountDTO mapToPostPromoCountDTO(Seller seller){
        return new PostPromoCountDTO(seller.getId(), seller.getUsername(), seller.getPosts().values()
                .stream().filter(post -> post.getHasPromo().equals(true)).toList().size());
    }

    public static PostsPromoListResponseDTO mapToPostPromoListDTO(Seller seller){

        return new PostsPromoListResponseDTO(seller.getId(), seller.getUsername(), seller.getPosts().values()
                .stream().filter(post -> post.getHasPromo() && post.getHasPromo().equals(true)).map(PostMapper::toPostPromoResponseDTO).toList());
    }

    public static PricePostsProductsDTO mapToPricePostsProductsDTO(Seller seller){
        return new PricePostsProductsDTO(seller.getId(), seller.getUsername(), seller.getPosts().values()
                .stream().mapToDouble(post ->  post.getPrice() * (1 - post.getDiscount())).sum());
    }
}
