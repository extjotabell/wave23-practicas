package com.sprint.be_java_hisp_w23_g04.utils;

import com.sprint.be_java_hisp_w23_g04.dto.request.PostDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.PostResponseDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.ProductDTO;
import com.sprint.be_java_hisp_w23_g04.entity.Post;
import com.sprint.be_java_hisp_w23_g04.entity.Product;
import com.sprint.be_java_hisp_w23_g04.entity.User;

public class PostMapper {

    public static PostResponseDTO PostRequestDTOMapper() {
        return new PostResponseDTO();
    }

    /**
     * Maps a received PostDTO to a Post entity
     *
     * @param dto The PostDTO to be mapped
     * @param id  The id of the user who is saving the post
     * @return A Post entity resulting from the mapping process
     */
    public static Post map(PostDTO dto, int id) {
        return new Post(id, dto.getUserId(), dto.getProduct().getId(), dto.getDate(), dto.getCategory(), dto.getPrice());
    }

    public static PostResponseDTO mapperToPostResponseDTO(User user, Post post, Product product) {
        ProductDTO productDTO = ProductMapper.productDTOMapper(product);

        return new PostResponseDTO(
                user.getId(),
                post.getId(),
                post.getDate(),
                productDTO,
                post.getCategory(),
                post.getPrice()
        );
    }
}
