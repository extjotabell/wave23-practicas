package com.ospina.socialmeli.util.mapper;

import com.ospina.socialmeli.dto.response.FollowersCountDTO;
import com.ospina.socialmeli.entity.user.Seller;

public class DTOMapper {
    public static FollowersCountDTO mapToFollowersCountDTO(Seller seller) {
        return new FollowersCountDTO(seller.getId(), seller.getUsername(), seller.getFollower().size());
    }
}
