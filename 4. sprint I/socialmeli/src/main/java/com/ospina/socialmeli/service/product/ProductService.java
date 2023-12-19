package com.ospina.socialmeli.service.product;

import com.ospina.socialmeli.dto.request.PostRequestDTO;
import com.ospina.socialmeli.dto.response.FollowedPostsListDTO;
import com.ospina.socialmeli.dto.request.PostPromoRequestDTO;
import com.ospina.socialmeli.dto.response.PostResponseDTO;

public interface ProductService {
    PostResponseDTO postProduct(PostRequestDTO postRequestDTO);

    PostResponseDTO postPromoProduct(PostPromoRequestDTO postPromoRequestDTO);

    FollowedPostsListDTO followedPostsList(Long userId, String order);
}
