package com.sprint.be_java_hisp_w23_g04.utils;

import com.sprint.be_java_hisp_w23_g04.dto.response.PostResponseDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.ProductDTO;
import com.sprint.be_java_hisp_w23_g04.entity.Post;
import com.sprint.be_java_hisp_w23_g04.entity.PromoPost;

public class PostMapper {

    public static PostResponseDTO PostRequestDTOMapper(int userId, Post post){
        ProductDTO productDTO = ProductMapper.productDTOMapper(post.getProduct());
        if(post instanceof PromoPost){
            return new PostResponseDTO(
                    userId,
                    post.getId(),
                    post.getDate(),
                    productDTO,
                    post.getCategory(),
                    post.getPrice(),
                    ((PromoPost) post).isHasPromo(),
                    ((PromoPost) post).getDiscount()
            );
        }
        return new PostResponseDTO(
                userId,
                post.getId(),
                post.getDate(),
                productDTO,
                post.getCategory(),
                post.getPrice(),
                false,
                0.0
        );
    }
}
