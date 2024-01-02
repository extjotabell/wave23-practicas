package com.ospina.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FollowersCountDTO {
    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("followers_count")
    private Integer followersCount;

    public FollowersCountDTO(Long userId, String userName, Integer followersCount) {
        this.userId = userId;
        this.userName = userName;
        this.followersCount = followersCount;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }
}
