package com.ospina.socialmeli.util;

import com.ospina.socialmeli.dto.response.FollowedListDTO;
import com.ospina.socialmeli.dto.response.UserDTO;
import com.ospina.socialmeli.util.mapper.UserMapper;

import java.util.List;

public class FollowedListDTOTestDataBuilder {
    public Long userID;
    public String userName;
    public List<UserDTO> followed;

    public FollowedListDTOTestDataBuilder followedListDTOByDefault() {
        this.userID = 1L;
        this.userName = "username1";
        this.followed = List.of();
        return this;
    }

    public FollowedListDTOTestDataBuilder followedListDTOWithFollowed() {
        this.userID = 1L;
        this.userName = "username1";
        this.followed = List.of(
                UserMapper.mapToDTO(new SellerTestDataBuilder().sellerByDefault().withId(101L).build()),
                UserMapper.mapToDTO(new SellerTestDataBuilder().sellerByDefault().withId(102L).build()),
                UserMapper.mapToDTO(new SellerTestDataBuilder().sellerByDefault().withId(103L).build())
        );
        return this;
    }

    public FollowedListDTO build() {
        return new FollowedListDTO(userID, userName, followed);
    }
}
