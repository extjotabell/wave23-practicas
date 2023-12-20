package com.example.be_java_hisp_w23_g3.util;

import com.example.be_java_hisp_w23_g3.dto.ProductDTO;
import com.example.be_java_hisp_w23_g3.dto.request.PostPromoRequestDTO;
import com.example.be_java_hisp_w23_g3.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w23_g3.dto.response.FollowedPostsListDTO;
import com.example.be_java_hisp_w23_g3.dto.response.PostPromoResponseDTO;
import com.example.be_java_hisp_w23_g3.dto.response.PostResponseDTO;
import com.example.be_java_hisp_w23_g3.entity.Post;
import com.example.be_java_hisp_w23_g3.entity.PostPromo;
import com.example.be_java_hisp_w23_g3.entity.Product;
import com.example.be_java_hisp_w23_g3.entity.Seller;
import com.example.be_java_hisp_w23_g3.exception.ValidationException;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public static Post toPostPromo(PostPromoRequestDTO postPromoRequestDTO, Seller seller, Long id){
        Product product = ProductMapper.toProduct(postPromoRequestDTO.getProduct());

        // Parse string of dd-MM-yyyy to LocalDate
        ArgumentValidator.validateRequired(postPromoRequestDTO.getDate(), "Date is required");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(postPromoRequestDTO.getDate(), formatter);

        Post post = Post.build(id, seller, product, date, postPromoRequestDTO.getCategory(), postPromoRequestDTO.getPrice());
        return PostPromo.build(post,postPromoRequestDTO.getDiscount());
    }

    public static PostPromoResponseDTO toPostPromoResponseDTO(Seller seller, Long promoCount){
        return new PostPromoResponseDTO(seller.getId(), seller.getUsername(), promoCount);
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
