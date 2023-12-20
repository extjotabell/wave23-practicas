package com.example.be_java_hisp_w23_g3.service.post;

import com.example.be_java_hisp_w23_g3.dto.request.post.RequestPostDTO;
import com.example.be_java_hisp_w23_g3.dto.request.post.RequestPromoPostDTO;
import com.example.be_java_hisp_w23_g3.dto.response.post.FollowedPostsListDTO;
import com.example.be_java_hisp_w23_g3.dto.response.post.PromoPostCountDTO;
import com.example.be_java_hisp_w23_g3.dto.response.post.PromoPostsListDTO;

public interface PostService {
    void setNewPost(RequestPostDTO postDTO);
    FollowedPostsListDTO getFollowedPosts(Long userId, String order);
    void setNewPromoPost(RequestPromoPostDTO promoPostDTO);
    PromoPostCountDTO getPromoPostCount(Long userId);
    PromoPostsListDTO getPromoPostsList(Long userId);
}
