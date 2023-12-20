package com.example.be_java_hisp_w23_g3.dto.response.user;

import java.util.List;

public class FollowingListDTO extends ResponseUserDTO {

    private List<ResponseSellerDTO> following;
    public FollowingListDTO(Long userId, String userName, List<ResponseSellerDTO> following) {
        super(userId, userName);
        this.following = following;
    }

    public List<ResponseSellerDTO> getFollowing() {
        return following;
    }
}
