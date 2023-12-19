package com.ospina.socialmeli.util;

import com.ospina.socialmeli.dto.ProductDTO;
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
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;

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

    public static PostPromoResponseDTO toPostPromoResponseDTO(Post post){
        ProductDTO productDTO = ProductMapper.toProductDTO(post.getProduct());

        return new PostPromoResponseDTO(
            post.getSeller().getId(),
            post.getId(),
            post.getDate(),
            productDTO,
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
            parseDate(postRequestDTO.getDate()),
            postRequestDTO.getCategory(),
            postRequestDTO.getPrice()
        );
    }



public static Post toPostPromo(PostPromoRequestDTO postPromoRequestDTO, Seller seller, Long id){
    BigDecimal price = BigDecimal.valueOf(postPromoRequestDTO.getPrice());

    if (postPromoRequestDTO.getHasPromo()) {
        BigDecimal discount = BigDecimal.valueOf(postPromoRequestDTO.getDiscount());
        price = price.subtract(price.multiply(discount));
    }

    price = price.setScale(2, RoundingMode.HALF_UP);

    return Post.build(
        id,
        seller,
        ProductMapper.toProduct(postPromoRequestDTO.getProduct()),
        parseDate(postPromoRequestDTO.getDate()),
        postPromoRequestDTO.getCategory(),
        price.doubleValue(),
        postPromoRequestDTO.getHasPromo(),
        postPromoRequestDTO.getDiscount()
    );
}

    private static LocalDate parseDate(String dateStr) {
        ArgumentValidator.validateRequired(dateStr, "Date is required");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(dateStr, formatter);
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

    public static PromoPostsFromSellerListDTO mapToPromoPostsFromSellerListDTO(List<Post> posts, Long userId, String userName) {
        return new PromoPostsFromSellerListDTO(userId, userName, posts.stream()
                .map(PostMapper::toPostPromoResponseDTO).toList());
    }

}
