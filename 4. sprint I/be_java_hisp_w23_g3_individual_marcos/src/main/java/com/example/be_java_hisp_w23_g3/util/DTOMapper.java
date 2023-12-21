package com.example.be_java_hisp_w23_g3.util;

import com.example.be_java_hisp_w23_g3.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w23_g3.dto.response.PromoPostCountResponseDTO;
import com.example.be_java_hisp_w23_g3.entity.Seller;

public class DTOMapper {
    public static FollowersCountDTO mapToFollowersCountDTO(Seller seller) {
        return new FollowersCountDTO(seller.getId(), seller.getUsername(), seller.getFollower().size());
    }
    public static PromoPostCountResponseDTO mapToPromoPostCountDTO(Seller seller) {
        int promoPostCount = (int) seller.getPosts().values()
                .stream()
                .filter(post -> Boolean.TRUE.equals(post.getHasPromo()))
                .count();

        return new PromoPostCountResponseDTO(seller.getId(), seller.getUsername(), promoPostCount);
    }



}