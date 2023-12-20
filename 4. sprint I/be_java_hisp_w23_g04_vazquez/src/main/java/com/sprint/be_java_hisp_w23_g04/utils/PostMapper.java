package com.sprint.be_java_hisp_w23_g04.utils;

import com.sprint.be_java_hisp_w23_g04.dto.request.PostPromoDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.PostResponseDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.ProductDTO;
import com.sprint.be_java_hisp_w23_g04.entity.Post;
import com.sprint.be_java_hisp_w23_g04.entity.PostPromo;

public class PostMapper {

    public static PostResponseDTO PostRequestDTOMapper(int userId, PostPromo post) {
        ProductDTO productDTO = ProductMapper.productDTOMapper(post.getProduct());

        return new PostResponseDTO(
                userId,
                post.getId(),
                post.getDate(),
                productDTO,
                post.getCategory(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount());
    }
}
