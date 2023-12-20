package com.ospina.socialmeli.util;

import com.ospina.socialmeli.dto.request.PostPromoRequestDTO;
import com.ospina.socialmeli.dto.request.PostRequestDTO;
import com.ospina.socialmeli.dto.response.FollowedPostsListDTO;
import com.ospina.socialmeli.dto.response.PostPromoResponseDTO;
import com.ospina.socialmeli.dto.response.PostResponseDTO;
import com.ospina.socialmeli.dto.response.PromoPostsFromSellerListDTO;
import com.ospina.socialmeli.entity.Post;
import com.ospina.socialmeli.entity.Seller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.math.BigDecimal;
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

    public static PostPromoResponseDTO toPostPromoResponseDTO(Post post){
        return new PostPromoResponseDTO(
            post.getSeller().getId(),
            post.getId(),
            post.getDate(),
            ProductMapper.toProductDTO(post.getProduct()),
            post.getCategory(),
            post.getPrice(),
            post.isHasDiscount(),
            post.getDiscount()
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

    public static Post toPostPromo(PostPromoRequestDTO postPromoRequestDTO, Seller seller, Long id){
        BigDecimal price = BigDecimal.valueOf(postPromoRequestDTO.getPrice());

        if (postPromoRequestDTO.getHasPromo()) {
            price = price.subtract(price.multiply(BigDecimal.valueOf(postPromoRequestDTO.getDiscount())));
        }

        return Post.build(
            id,
            seller,
            ProductMapper.toProduct(postPromoRequestDTO.getProduct()),
            LocalDate.parse(postPromoRequestDTO.getDate(), formatter),
            postPromoRequestDTO.getCategory(),
            price.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(),
            postPromoRequestDTO.getHasPromo(),
            postPromoRequestDTO.getDiscount()
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

    public static PromoPostsFromSellerListDTO mapToPromoPostsFromSellerListDTO(List<Post> posts, Long userId, String userName) {
        return new PromoPostsFromSellerListDTO(userId, userName, posts.stream().map(PostMapper::toPostPromoResponseDTO).toList());
    }
}