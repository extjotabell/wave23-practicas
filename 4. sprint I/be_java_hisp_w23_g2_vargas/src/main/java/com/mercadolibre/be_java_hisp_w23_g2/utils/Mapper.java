package com.mercadolibre.be_java_hisp_w23_g2.utils;

import com.mercadolibre.be_java_hisp_w23_g2.dto.*;
import com.mercadolibre.be_java_hisp_w23_g2.entity.Post;
import com.mercadolibre.be_java_hisp_w23_g2.entity.Product;
import com.mercadolibre.be_java_hisp_w23_g2.entity.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class for mapping entities to DTOs and vice versa.
 */
public class Mapper {

    private static Mapper instance = null;
    private Mapper(){

    }

    public static Mapper getInstance() {
        if(instance==null){
            instance=new Mapper();
        }
        return instance;
    }

    public PostFollowedDTO mapPostFollowedDTO(int id, List<Post> posts) {
        return new PostFollowedDTO(id,posts.stream().map(this::mapPostToPostDTO).toList());
    }

    public PostDTO mapPostToPostDTO(Post post) {
        return new PostDTO(post.getUserId(),post.getId(), post.getDate(),mapProductToProductDTO(post.getProduct()),post.getCategory(),post.getPrice());
    }

    public Post mapPostDTOToPost(PostDTO postDTO) {
        return new Post(postDTO.getId(),postDTO.getUserId(), postDTO.getDate(),mapProductDTOToProduct(postDTO.getProduct()),postDTO.getCategory(),postDTO.getPrice());
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

    public Post mapPostPromoDTOToPost(PostPromoDTO postPromoDTO) {
        return new Post(postPromoDTO.getId(),postPromoDTO.getUserId(),postPromoDTO.getDate(),mapProductDTOToProduct(postPromoDTO.getProduct()),postPromoDTO.getCategory(),postPromoDTO.getPrice(), postPromoDTO.isHas_promo(),postPromoDTO.getDiscount());
    }

    public UserPromoCountDTO mapUserPromoCountDTO(User user) {
         int count = (int)user.getPosts().stream()
                .filter(Post::isHas_promo)
                .count();
        return new UserPromoCountDTO(user.getId(), user.getUserName(), count);
    }

    public PostPromoDTO mapPostToPostPromoDTO(Post post) {
        return new PostPromoDTO(post.getUserId(),post.getId(),post.getDate(),mapProductToProductDTO(post.getProduct()),post.getCategory(),post.getPrice(),post.isHas_promo(),post.getDiscount());
    }

}
