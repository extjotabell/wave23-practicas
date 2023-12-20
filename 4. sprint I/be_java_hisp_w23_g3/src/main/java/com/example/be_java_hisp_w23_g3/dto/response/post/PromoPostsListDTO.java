package com.example.be_java_hisp_w23_g3.dto.response.post;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PromoPostsListDTO {
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("user_name")
    private String userName;
    private List<ResponsePromoPostDTO> posts;

    public PromoPostsListDTO(Long userId, String userName, List<ResponsePromoPostDTO> posts) {
        this.userId = userId;
        this.userName = userName;
        this.posts = posts;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<ResponsePromoPostDTO> getPosts() {
        return posts;
    }
}
