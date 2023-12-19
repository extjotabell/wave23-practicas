package com.ospina.socialmeli.util;

import com.ospina.socialmeli.dto.ProductDTO;
import com.ospina.socialmeli.dto.request.PostRequestDTO;
import com.ospina.socialmeli.dto.response.FollowedPostsListDTO;
import com.ospina.socialmeli.dto.response.PostResponseDTO;
import com.ospina.socialmeli.entity.Post;
import com.ospina.socialmeli.entity.Product;
import com.ospina.socialmeli.entity.Seller;
import com.ospina.socialmeli.exception.ValidationException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PostMapper {

    private static final String ORDER_DATE_ASC = "DATE_ASC";
    private static final String ORDER_DATE_DESC = "DATE_DESC";

    public static PostResponseDTO toPostResponseDTO(Post post){
        ProductDTO productDTO = ProductMapper.toProductDTO(post.getProduct());

        return new PostResponseDTO(
            post.getSeller().getId(),
            post.getId(),
            post.getDate(),
            productDTO,
            post.getCategory(),
            post.getPrice()
        );
    }

    public static Post toPost(PostRequestDTO postRequestDTO, Seller seller, Long id){
        Product product = ProductMapper.toProduct(postRequestDTO.getProduct());

        // Parse string of dd-MM-yyyy to LocalDate
        ArgumentValidator.validateRequired(postRequestDTO.getDate(), "Date is required");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(postRequestDTO.getDate(), formatter);

        return Post.build(
            id,
            seller,
            product,
            date,
            postRequestDTO.getCategory(),
            postRequestDTO.getPrice()
        );
    }

    public static FollowedPostsListDTO mapToFollowedPostsListDTO(List<Post> posts, Long userId, String order) {
        if(ORDER_DATE_ASC.equalsIgnoreCase(order))
            return new FollowedPostsListDTO(userId, posts.stream()
                    .sorted((p1, p2) -> p1.getDate().compareTo(p2.getDate()))
                    .map(PostMapper::toPostResponseDTO).toList());

        if(ORDER_DATE_DESC.equalsIgnoreCase(order))
            return new FollowedPostsListDTO(userId, posts.stream()
                    .sorted((p1, p2) -> p2.getDate().compareTo(p1.getDate()))
                    .map(PostMapper::toPostResponseDTO).toList());

        return new FollowedPostsListDTO(userId, posts.stream()
                .map(PostMapper::toPostResponseDTO).toList());
    }

}
