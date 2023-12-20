package com.example.be_java_hisp_w23_g3.dto.response.post;

import com.example.be_java_hisp_w23_g3.dto.response.post.ResponsePostDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FollowedPostsListDTO {
    @JsonProperty("user_id")
    private Long userId;
    private List<ResponsePostDTO> posts;

    public FollowedPostsListDTO(Long userId, List<ResponsePostDTO> posts) {
        this.userId = userId;
        this.posts = posts;
    }

    public Long getUserId() {
        return userId;
    }

    public List<ResponsePostDTO> getPosts() {
        return posts;
    }
}
