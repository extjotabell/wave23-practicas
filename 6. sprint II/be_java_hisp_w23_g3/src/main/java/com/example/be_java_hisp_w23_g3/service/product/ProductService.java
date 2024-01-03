package com.example.be_java_hisp_w23_g3.service.product;

import com.example.be_java_hisp_w23_g3.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w23_g3.dto.response.FollowedPostsListDTO;
import com.example.be_java_hisp_w23_g3.dto.response.PostResponseDTO;

public interface ProductService {
    PostResponseDTO postProduct(PostRequestDTO postRequestDTO);

    FollowedPostsListDTO followedPostsList(Long userId, String order);
}
