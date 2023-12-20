package com.example.be_java_hisp_w23_g3.util.mapper;

import com.example.be_java_hisp_w23_g3.dto.response.FollowersCountResponseDTO;
import com.example.be_java_hisp_w23_g3.entity.user.Seller;

public class DTOMapper {
    public static FollowersCountResponseDTO mapToFollowersCountDTO(Seller seller) {
        return new FollowersCountResponseDTO(seller.getId(), seller.getUsername(), seller.getFollower().size());
    }
}
