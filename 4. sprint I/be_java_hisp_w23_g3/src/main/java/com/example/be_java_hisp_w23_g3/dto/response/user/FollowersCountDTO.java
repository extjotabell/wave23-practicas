package com.example.be_java_hisp_w23_g3.dto.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FollowersCountDTO {
    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("followers_count")
    private Integer followerCount;

    public FollowersCountDTO(Long userId, String userName, Integer followerCount) {
        this.userId = userId;
        this.userName = userName;
        this.followerCount = followerCount;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getFollowerCount() {
        return followerCount;
    }
}
