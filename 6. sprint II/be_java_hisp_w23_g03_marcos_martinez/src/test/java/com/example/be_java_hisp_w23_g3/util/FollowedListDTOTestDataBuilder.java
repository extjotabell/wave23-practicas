package com.example.be_java_hisp_w23_g3.util;

import com.example.be_java_hisp_w23_g3.dto.response.FollowedListDTO;
import com.example.be_java_hisp_w23_g3.dto.response.UserDTO;
import com.example.be_java_hisp_w23_g3.util.mapper.UserMapper;

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
