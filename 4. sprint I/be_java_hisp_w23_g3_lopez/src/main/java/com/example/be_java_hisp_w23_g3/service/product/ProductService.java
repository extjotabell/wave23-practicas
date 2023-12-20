package com.example.be_java_hisp_w23_g3.service.product;

import com.example.be_java_hisp_w23_g3.dto.request.PostPromoRequestDTO;
import com.example.be_java_hisp_w23_g3.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w23_g3.dto.response.FollowedPostsListDTO;
import com.example.be_java_hisp_w23_g3.dto.response.PostPromoResponseDTO;
import com.example.be_java_hisp_w23_g3.dto.response.PostResponseDTO;
import com.example.be_java_hisp_w23_g3.dto.response.ProductCountDTO;

public interface ProductService {
    PostResponseDTO getPost(Long productId);
    PostResponseDTO postProduct(PostRequestDTO postRequestDTO);
    PostPromoResponseDTO postPromoProduct(PostPromoRequestDTO postRequestDTO);
    ProductCountDTO countPromoPosts(Long userId);
    FollowedPostsListDTO followedPostsList(Long userId, String order);
}
