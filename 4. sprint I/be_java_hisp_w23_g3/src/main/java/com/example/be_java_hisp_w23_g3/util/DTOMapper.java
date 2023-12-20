package com.example.be_java_hisp_w23_g3.util;

import com.example.be_java_hisp_w23_g3.dto.request.post.RequestPostDTO;
import com.example.be_java_hisp_w23_g3.dto.request.post.RequestProductDTO;
import com.example.be_java_hisp_w23_g3.dto.request.post.RequestPromoPostDTO;
import com.example.be_java_hisp_w23_g3.dto.response.post.*;
import com.example.be_java_hisp_w23_g3.dto.response.user.ResponseSellerDTO;
import com.example.be_java_hisp_w23_g3.dto.response.user.ResponseUserDTO;
import com.example.be_java_hisp_w23_g3.dto.response.user.FollowersCountDTO;
import com.example.be_java_hisp_w23_g3.dto.response.user.FollowersListDTO;
import com.example.be_java_hisp_w23_g3.dto.response.user.FollowingListDTO;
import com.example.be_java_hisp_w23_g3.entity.*;

import java.util.Comparator;
import java.util.List;

public class DTOMapper {

    private static final String ORDER_FOLLOWERS_NAME_ASC = "name_asc";
    private static final String ORDER_FOLLOWERS_NAME_DESC = "name_desc";
    private static final String ORDER_POSTS_DATE_ASC = "date_asc";
    private static final String ORDER_POSTS_DATE_DESC = "date_desc";
    public static ResponseUserDTO mapToUserDTO(User user) {
        return new ResponseUserDTO(user.getId(), user.getUsername());
    }
    public static ResponseSellerDTO mapToSellerDTO(Seller seller) {
        return new ResponseSellerDTO(seller.getId(), seller.getUsername());
    }
    public static FollowersListDTO mapToFollowersListDTO(Seller seller, String order) {
        if (ORDER_FOLLOWERS_NAME_ASC.equalsIgnoreCase(order))
            return new FollowersListDTO(seller.getId(), seller.getUsername(),
                    seller.getFollowers().stream()
                            .sorted(Comparator.comparing(User::getUsername))
                            .map(DTOMapper::mapToUserDTO).toList());

        if (ORDER_FOLLOWERS_NAME_DESC.equalsIgnoreCase(order))
            return new FollowersListDTO(seller.getId(), seller.getUsername(),
                    seller.getFollowers().stream()
                            .sorted(Comparator.comparing(User::getUsername).reversed())
                            .map(DTOMapper::mapToUserDTO).toList());

        return new FollowersListDTO(seller.getId(), seller.getUsername(),
                seller.getFollowers().stream().map(DTOMapper::mapToUserDTO).toList());
    }
    public static FollowingListDTO mapToFollowingListDTO(User user, String order) {
        if (ORDER_FOLLOWERS_NAME_ASC.equalsIgnoreCase(order))
            return new FollowingListDTO(user.getId(), user.getUsername(),
                    user.getFollowing().stream()
                            .sorted(Comparator.comparing(Seller::getUsername))
                            .map(DTOMapper::mapToSellerDTO).toList());

        if (ORDER_FOLLOWERS_NAME_DESC.equalsIgnoreCase(order))
            return new FollowingListDTO(user.getId(), user.getUsername(),
                    user.getFollowing().stream()
                            .sorted(Comparator.comparing(Seller::getUsername).reversed())
                            .map(DTOMapper::mapToSellerDTO).toList());

        return new FollowingListDTO(user.getId(), user.getUsername(),
                user.getFollowing().stream().map(DTOMapper::mapToSellerDTO).toList());
    }
    public static FollowersCountDTO mapToFollowersCountDTO(Seller seller) {
        return new FollowersCountDTO(seller.getId(), seller.getUsername(), seller.getFollowers().size());
    }
    public static Post mapToPost(RequestPostDTO postDTO, Seller seller) {
        return Post.build(seller, mapToProduct(postDTO.getProduct()),
                postDTO.getDate(), postDTO.getCategory(), postDTO.getPrice());
    }
    public static PromoPost mapToPromoPost(RequestPromoPostDTO promoPostDTO, Seller seller) {
        return PromoPost.build(mapToPost(promoPostDTO, seller), promoPostDTO.isHasPromo(), promoPostDTO.getDiscount());
    }
    public static ResponsePromoPostDTO mapToResponsePromoPostDTO(PromoPost post) {
        return new ResponsePromoPostDTO(post.getSeller().getId(), post.getId(), post.getDate(),
                mapToResponseProductDTO(post.getProduct()), post.getCategory(), post.getPrice(),
                post.isHasPromo(), post.getDiscount());
    }
    public static ResponsePostDTO mapToResponsePostDTO(Post post) {
        return new ResponsePostDTO(post.getSeller().getId(), post.getId(), post.getDate(),
                mapToResponseProductDTO(post.getProduct()), post.getCategory(), post.getPrice());
    }
    public static Product mapToProduct(RequestProductDTO productDTO) {
        return Product.build(productDTO.getId(), productDTO.getName(), productDTO.getType(),
                productDTO.getBrand(), productDTO.getColor(), productDTO.getNotes());
    }
    public static ResponseProductDTO mapToResponseProductDTO(Product product) {
        return new ResponseProductDTO(product.getId(), product.getName(), product.getType(),
                product.getBrand(), product.getColor(), product.getNotes());
    }
    public static FollowedPostsListDTO mapToFollowedPostsListDTO(List<Post> posts, Long userId, String order) {
        if (ORDER_POSTS_DATE_ASC.equalsIgnoreCase(order))
            return new FollowedPostsListDTO(userId, posts.stream()
                    .sorted(Comparator.comparing(Post::getDate))
                    .map(post -> post instanceof PromoPost ?
                            mapToResponsePromoPostDTO((PromoPost) post) :
                            mapToResponsePostDTO(post))
                    .toList());

        if (ORDER_POSTS_DATE_DESC.equalsIgnoreCase(order))
            return new FollowedPostsListDTO(userId, posts.stream()
                    .sorted(Comparator.comparing(Post::getDate).reversed())
                    .map(post -> post instanceof PromoPost ?
                            mapToResponsePromoPostDTO((PromoPost) post) :
                            mapToResponsePostDTO(post))
                    .toList());

        return new FollowedPostsListDTO(userId, posts.stream()
                .map(post -> post instanceof PromoPost ?
                        mapToResponsePromoPostDTO((PromoPost) post) :
                        mapToResponsePostDTO(post))
                .toList());
    }
    public static PromoPostCountDTO mapToPromoPostCountDTO(List<Post> posts, Long userId, String userName) {
        return new PromoPostCountDTO(userId, userName, posts.size());
    }
    public static PromoPostsListDTO mapToPromoPostsListDTO(List<PromoPost> posts, Long userId, String userName) {
        return new PromoPostsListDTO(userId, userName,
                posts.stream().map(DTOMapper::mapToResponsePromoPostDTO).toList());
    }
}
