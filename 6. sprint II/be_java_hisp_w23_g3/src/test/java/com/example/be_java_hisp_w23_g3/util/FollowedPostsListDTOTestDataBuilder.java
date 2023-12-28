package com.example.be_java_hisp_w23_g3.util;

import com.example.be_java_hisp_w23_g3.dto.response.FollowedPostsListDTO;
import com.example.be_java_hisp_w23_g3.dto.response.PostResponseDTO;

import java.util.List;

public class FollowedPostsListDTOTestDataBuilder {

    private Long userId;
    private List<PostResponseDTO> posts;

    public FollowedPostsListDTOTestDataBuilder followedPostsListDTOByDefault() {
        this.userId = 1L;
        this.posts = List.of();
        return this;
    }

    public FollowedPostsListDTOTestDataBuilder followedPostsListDTOWithPosts() {
        this.userId = 1L;
        this.posts = List.of(new PostResponseDTOTestDataBuilder().postResponseDTOByDefault().withPostId(101L).build());
        return this;
    }

    public FollowedPostsListDTOTestDataBuilder withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public FollowedPostsListDTOTestDataBuilder withPosts(List<PostResponseDTO> posts) {
        this.posts = posts;
        return this;
    }

    public FollowedPostsListDTO build() {
        return new FollowedPostsListDTO(userId, posts);
    }


}
