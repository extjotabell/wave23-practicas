package com.example.be_java_hisp_w23_g3.dto.response.user;

import java.util.List;

public class FollowersListDTO extends ResponseSellerDTO {
    private final List<ResponseUserDTO> followers;

    public FollowersListDTO(Long userId, String userName, List<ResponseUserDTO> followers) {
        super(userId, userName);
        this.followers = followers;
    }

    public List<ResponseUserDTO> getFollowers() {
        return followers;
    }
}
