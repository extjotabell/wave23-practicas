package com.ospina.socialmeli.util;

import com.ospina.socialmeli.dto.response.FollowersListDTO;
import com.ospina.socialmeli.dto.response.UserDTO;
import com.ospina.socialmeli.util.mapper.UserMapper;

import java.util.List;

public class FollowersListDTOTestDataBuilder {
    private Long userId;
    private String userName;
    private List<UserDTO> followers;

    public FollowersListDTOTestDataBuilder followersListDTOByDefault() {
        this.userId = 1L;
        this.userName = "username1";
        this.followers = List.of();
        return this;
    }

    public FollowersListDTOTestDataBuilder followersListDTOWithFollowers() {
        this.userId = 1L;
        this.userName = "username1";
        this.followers = List.of(
                UserMapper.mapToDTO(new UserTestDataBuilder().userByDefault().withId(101L).build()),
                UserMapper.mapToDTO(new UserTestDataBuilder().userByDefault().withId(102L).build()),
                UserMapper.mapToDTO(new UserTestDataBuilder().userByDefault().withId(103L).build())
        );
        return this;
    }

    public FollowersListDTO build() {
        return new FollowersListDTO(userId, userName, followers);
    }
}
