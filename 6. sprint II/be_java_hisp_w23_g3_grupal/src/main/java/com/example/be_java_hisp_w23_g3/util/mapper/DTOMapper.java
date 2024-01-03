package com.example.be_java_hisp_w23_g3.util.mapper;

import com.example.be_java_hisp_w23_g3.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w23_g3.entity.user.Seller;

public class DTOMapper {
    public static FollowersCountDTO mapToFollowersCountDTO(Seller seller) {
        return new FollowersCountDTO(seller.getId(), seller.getUsername(), seller.getFollower().size());
    }
}
