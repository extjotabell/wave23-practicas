package com.ospina.socialmeli.util.mapper;

import com.ospina.socialmeli.dto.request.PostRequestDTO;
import com.ospina.socialmeli.dto.response.FollowedPostsListDTO;
import com.ospina.socialmeli.dto.response.PostResponseDTO;
import com.ospina.socialmeli.entity.product.Post;
import com.ospina.socialmeli.entity.user.Seller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {

    private static final String ORDER_DATE_ASC = "DATE_ASC";
    private static final String ORDER_DATE_DESC = "DATE_DESC";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static PostResponseDTO toPostResponseDTO(Post post){
        return new PostResponseDTO(
                post.getSeller().getId(),
                post.getId(),
                post.getDate(),
                ProductMapper.toProductDTO(post.getProduct()),
                post.getCategory(),
                post.getPrice()
        );
    }

    public static Post toPost(PostRequestDTO postRequestDTO, Seller seller, Long id){
        return Post.build(
                id,
                seller,
                ProductMapper.toProduct(postRequestDTO.getProduct()),
                LocalDate.parse(postRequestDTO.getDate(), formatter),
                postRequestDTO.getCategory(),
                postRequestDTO.getPrice()
        );
    }

    public static FollowedPostsListDTO mapToFollowedPostsListDTO(List<Post> posts, Long userId, String order) {
        Comparator<Post> comparator;
        if (ORDER_DATE_DESC.equalsIgnoreCase(order)) {
            comparator = Comparator.comparing(Post::getDate).reversed();
        } else {
            comparator = Comparator.comparing(Post::getDate);
        }
        return new FollowedPostsListDTO(userId, posts.stream()
                .sorted(comparator)
                .map(PostMapper::toPostResponseDTO)
                .collect(Collectors.toList()));
    }

}
