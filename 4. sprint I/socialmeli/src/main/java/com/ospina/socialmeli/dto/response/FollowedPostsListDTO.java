package com.ospina.socialmeli.dto.response;

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
