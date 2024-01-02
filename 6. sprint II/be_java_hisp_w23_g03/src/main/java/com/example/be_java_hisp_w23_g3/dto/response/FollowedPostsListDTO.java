package com.example.be_java_hisp_w23_g3.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FollowedPostsListDTO {
    @JsonProperty("user_id")
    private Long userId;
    private List<PostResponseDTO> posts;

    public FollowedPostsListDTO(Long userId, List<PostResponseDTO> posts) {
        this.userId = userId;
        this.posts = posts;
    }

    public Long getUserId() {
        return userId;
    }

    public List<PostResponseDTO> getPosts() {
        return posts;
    }
}
