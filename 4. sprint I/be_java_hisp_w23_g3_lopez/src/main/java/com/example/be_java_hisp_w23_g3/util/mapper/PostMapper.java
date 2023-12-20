package com.example.be_java_hisp_w23_g3.util.mapper;

import com.example.be_java_hisp_w23_g3.dto.request.PostPromoRequestDTO;
import com.example.be_java_hisp_w23_g3.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w23_g3.dto.response.FollowedPostsResponseDTO;
import com.example.be_java_hisp_w23_g3.dto.response.PostPromoResponseDTO;
import com.example.be_java_hisp_w23_g3.dto.response.PostResponseDTO;
import com.example.be_java_hisp_w23_g3.entity.product.Post;
import com.example.be_java_hisp_w23_g3.entity.user.Seller;

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

    public static PostPromoResponseDTO toPostPromoResponseDTO(Post post){
        return new PostPromoResponseDTO(
                post.getSeller().getId(),
                post.getId(),
                post.getDate(),
                ProductMapper.toProductDTO(post.getProduct()),
                post.getCategory(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount()
        );
    }

    public static Post toPost(PostPromoRequestDTO postPromoRequestDTO, Seller seller, Long id){
        return Post.build(
                id,
                seller,
                ProductMapper.toProduct(postPromoRequestDTO.getProduct()),
                LocalDate.parse(postPromoRequestDTO.getDate(), formatter),
                postPromoRequestDTO.getCategory(),
                postPromoRequestDTO.getPrice(),
                postPromoRequestDTO.isHasPromo(),
                postPromoRequestDTO.getDiscount()
        );
    }

    public static FollowedPostsResponseDTO mapToFollowedPostsListDTO(List<Post> posts, Long userId, String order) {
        Comparator<Post> comparator;
        if (ORDER_DATE_DESC.equalsIgnoreCase(order)) {
            comparator = Comparator.comparing(Post::getDate).reversed();
        } else if (ORDER_DATE_ASC.equalsIgnoreCase(order)) {
            comparator = Comparator.comparing(Post::getDate);
        } else {
            comparator = Comparator.comparing(Post::getDate);
        }
        return new FollowedPostsResponseDTO(userId, posts.stream()
                .sorted(comparator)
                .map(PostMapper::toPostResponseDTO)
                .collect(Collectors.toList()));
    }

}
