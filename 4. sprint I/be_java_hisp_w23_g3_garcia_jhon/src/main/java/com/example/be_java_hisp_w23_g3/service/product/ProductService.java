package com.example.be_java_hisp_w23_g3.service.product;

import com.example.be_java_hisp_w23_g3.dto.request.PostPromoRequestDTO;
import com.example.be_java_hisp_w23_g3.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w23_g3.dto.response.*;

public interface ProductService {
    PostResponseDTO postProduct(PostRequestDTO postRequestDTO);

    PostResponseDTO postProduct(PostPromoRequestDTO postRequestDTO);

    FollowedPostsListDTO followedPostsList(Long userId, String order);

    PostPromoCountDTO getPostsPromoCount(Long userID);

    PostsPromoListResponseDTO getPostsPromoBySeller(Long userID);

    PricePostsProductsDTO getPricePostsProducts(Long userID);
}
