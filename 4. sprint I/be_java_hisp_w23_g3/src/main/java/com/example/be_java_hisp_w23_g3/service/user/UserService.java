package com.example.be_java_hisp_w23_g3.service.user;

import com.example.be_java_hisp_w23_g3.dto.response.user.FollowersCountDTO;
import com.example.be_java_hisp_w23_g3.dto.response.user.FollowersListDTO;
import com.example.be_java_hisp_w23_g3.dto.response.user.FollowingListDTO;

import java.util.Optional;

public interface UserService {
    void setNewFollower(Long userId, Long userIdToFollow);
    void unfollow(Long userId, Long userIdToUnfollow);
    FollowersCountDTO getFollowersCount(Long userId);
    FollowersListDTO getFollowers(Long userId, String order);
    FollowingListDTO getFollowing(Long userId, String order);
}
