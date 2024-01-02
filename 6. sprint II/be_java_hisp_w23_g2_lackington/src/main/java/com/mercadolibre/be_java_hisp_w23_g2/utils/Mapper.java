package com.mercadolibre.be_java_hisp_w23_g2.utils;

import com.mercadolibre.be_java_hisp_w23_g2.dto.PostBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.ProductBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.UserBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.requests.PostDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.PostsFollowedDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowedDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowersCountDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowersDTO;
import com.mercadolibre.be_java_hisp_w23_g2.entity.Post;
import com.mercadolibre.be_java_hisp_w23_g2.entity.Product;
import com.mercadolibre.be_java_hisp_w23_g2.entity.User;
import java.util.List;

/**
 * Utility class for mapping entities to DTOs and vice versa.
 */
public class Mapper {

  private Mapper() {
    throw new IllegalStateException("Utility class");
  }

  public static PostsFollowedDTO mapPostFollowedDTO(int id, List<Post> posts) {
    return new PostsFollowedDTO(id, posts.stream().map(Mapper::mapPostToPostBasicDTO).toList());
  }

  public static PostBasicDTO mapPostToPostBasicDTO(Post post) {
    return new PostBasicDTO(post.getUserId(), post.getId(), post.getDate(),
        mapProductToProductDTO(post.getProduct()), post.getCategory(), post.getPrice());
  }

  public static Post mapPostDTOToPost(PostDTO postDTO) {
    return new Post(null, postDTO.getUserId(), postDTO.getDate(),
        mapProductDTOToProduct(postDTO.getProduct()), postDTO.getCategory(),
        postDTO.getPrice());
  }

  public static ProductBasicDTO mapProductToProductDTO(Product product) {
    return new ProductBasicDTO(product.getId(), product.getName(), product.getType(),
        product.getBrand(), product.getColor(), product.getNotes());
  }

  public static Product mapProductDTOToProduct(ProductBasicDTO productBasicDTO) {
    return new Product(productBasicDTO.getId(), productBasicDTO.getName(),
        productBasicDTO.getType(), productBasicDTO.getBrand(), productBasicDTO.getColor(),
        productBasicDTO.getNotes());
  }

  public static UserBasicDTO mapUserDTO(User user) {
    return new UserBasicDTO(user.getId(), user.getUserName());
  }

  public static UserFollowersDTO mapUserFollowersDTO(User user) {
    return new UserFollowersDTO(user.getId(), user.getUserName(),
        user.getFollowers().stream().map(Mapper::mapUserDTO).toList());
  }

  public static UserFollowersCountDTO mapUserFollowersCountDTO(User user) {
    return new UserFollowersCountDTO(user.getId(), user.getUserName(),
        user.getFollowers().size());
  }

  public static UserFollowedDTO mapUserFollowedDTO(User user) {
    return new UserFollowedDTO(user.getId(), user.getUserName(),
        user.getFollowed().stream().map(Mapper::mapUserDTO).toList());
  }

}
