package com.mercadolibre.be_java_hisp_w23_g2.utils;

import com.mercadolibre.be_java_hisp_w23_g2.dto.*;
import com.mercadolibre.be_java_hisp_w23_g2.entity.Post;
import com.mercadolibre.be_java_hisp_w23_g2.entity.PostPromo;
import com.mercadolibre.be_java_hisp_w23_g2.entity.Product;
import com.mercadolibre.be_java_hisp_w23_g2.dto.UserFollowedDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.UserDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.UserFollowersCountDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.UserFollowersDTO;
import com.mercadolibre.be_java_hisp_w23_g2.entity.User;

import java.util.List;

/**
 * Utility class for mapping entities to DTOs and vice versa.
 */
public class Mapper {
    private static Mapper instance = null;
    private Mapper(){}

    public static Mapper getInstance() {
        if(instance==null){
            instance=new Mapper();
        }
        return instance;
    }

    public PostFollowedDTO mapPostFollowedDTO(int id, List<Post> posts) {
        return new PostFollowedDTO(id,posts.stream().map(post -> post instanceof PostPromo?mapPostToPostDTO((PostPromo) post):mapPostToPostDTO(post)).toList());
    }

    public PostDTO mapPostToPostDTO(Post post) {
        return new PostDTO(post.getUserId(),post.getId(), post.getDate(),mapProductToProductDTO(post.getProduct()),post.getCategory(),post.getPrice());
    }
    public PostPromoDTO mapPostToPostDTO(PostPromo post) {
        return new PostPromoDTO(post.getUserId(),post.getId(), post.getDate(),mapProductToProductDTO(post.getProduct()),post.getCategory(),post.getPrice(),post.isHasPromo(),post.getDiscount());
    }

    public Post mapPostDTOToPost(PostDTO postDTO) {
        return new Post(postDTO.getId(),postDTO.getUserId(), postDTO.getDate(),mapProductDTOToProduct(postDTO.getProduct()),postDTO.getCategory(),postDTO.getPrice());
    }
    public PostPromo mapPostPromoDTOToPostPromo(PostPromoDTO postDTO) {
        return new PostPromo(postDTO.getId(),postDTO.getUserId(), postDTO.getDate(),mapProductDTOToProduct(postDTO.getProduct()),postDTO.getCategory(),postDTO.getPrice(),postDTO.isHasPromo(),postDTO.getDiscount());
    }

    public ProductDTO mapProductToProductDTO(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getType(), product.getBrand(), product.getColor(), product.getNotes());
    }

    public Product mapProductDTOToProduct(ProductDTO productDTO) {
        return new Product(productDTO.getId(), productDTO.getName(), productDTO.getType(), productDTO.getBrand(), productDTO.getColor(), productDTO.getNotes());
    }

    public UserDTO mapUserDTO(User user) {
        return new UserDTO(user.getId(), user.getUserName());
    }

    public UserFollowersDTO mapUserFollowersDTO(User user) {
        return new UserFollowersDTO(user.getId(), user.getUserName(),
                                    user.getFollowers().stream().map(this::mapUserDTO).toList());
    }

    public UserFollowersCountDTO mapUserFollowersCountDTO(User user) {
        return new UserFollowersCountDTO(user.getId(), user.getUserName(), user.getFollowers().size());
    }

    public UserFollowedDTO mapUserFollowedDTO(User user) {
        return new UserFollowedDTO(user.getId(), user.getUserName(),
                                    user.getFollowed().stream().map(this::mapUserDTO).toList());
    }
    public PromoPostCountDTO mapPromoPostCountDTO(User user, Long postPromoCount){
        return new PromoPostCountDTO(user.getId(), user.getUserName() ,postPromoCount);
    }

    public UserMaxFollowersSimpleDTO mapUserMaxFollowersDTO(User user) {
        return new UserMaxFollowersSimpleDTO(user.getId(), user.getUserName(), user.getFollowers().size());
    }

    public UserMaxFollowersDTO mapUserMaxFollowersDTO(List<User> usersFollowers) {
        return new UserMaxFollowersListDTO(usersFollowers.stream().map(this::mapUserMaxFollowersDTO).toList());
    }
}
