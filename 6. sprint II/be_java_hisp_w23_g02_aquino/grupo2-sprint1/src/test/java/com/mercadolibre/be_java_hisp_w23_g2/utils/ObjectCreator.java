package com.mercadolibre.be_java_hisp_w23_g2.utils;

import com.mercadolibre.be_java_hisp_w23_g2.dto.PostBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.ProductBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.UserBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.requests.PostDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.PostsFollowedDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowedDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowersCountDTO;
import com.mercadolibre.be_java_hisp_w23_g2.entity.Post;
import com.mercadolibre.be_java_hisp_w23_g2.entity.Product;
import com.mercadolibre.be_java_hisp_w23_g2.entity.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Utility class for creating various objects used in testing scenarios.
 */
public class ObjectCreator {

  public static User createUser(Integer id, String name) {
    User user = new User();
    user.setId(id);
    user.setUserName(name);
    user.setFollowers(List.of());
    user.setFollowed(List.of());

    return user;
  }

  public static User createUser(Integer id) {
    User user = new User();
    user.setId(id);
    user.setFollowers(List.of());
    user.setFollowed(List.of());

    return user;
  }

  public static Post createPost(Integer id, Integer userId, LocalDate date) {
    Post post = new Post();
    post.setId(id);
    post.setUserId(userId);
    post.setProduct(new Product());
    post.setDate(date);

    return post;
  }

  public static Post createPost(LocalDate date) {
    Post post = new Post();
    post.setDate(date);
    post.setProduct(new Product());
    return post;
  }

  public static Post createPostRecent() {
    return createPost(LocalDate.now().minusDays(14));
  }

  public static Post createPostOld() {
    return createPost(LocalDate.now().minusDays(15));
  }

  public static PostDTO createPostWithProduct() {
    ProductBasicDTO productBasicDTO = new ProductBasicDTO();
    productBasicDTO.setId(1000);
    productBasicDTO.setBrand("Samsung");
    productBasicDTO.setName("Digital Camera");
    productBasicDTO.setType("Photography");
    productBasicDTO.setColor("Silver");
    productBasicDTO.setNotes("Professional digital camera for photographers");

    PostDTO payloadRequestDTO = new PostDTO();
    payloadRequestDTO.setUserId(1);
    payloadRequestDTO.setCategory(1);
    payloadRequestDTO.setDate(LocalDate.now());
    payloadRequestDTO.setPrice(10000.0);
    payloadRequestDTO.setProduct(productBasicDTO);

    return payloadRequestDTO;
  }

  public static UserFollowersCountDTO createUserFollowersCount() {
    UserFollowersCountDTO payloadResponseDTO = new UserFollowersCountDTO();
    payloadResponseDTO.setId(1);
    payloadResponseDTO.setUserName("John Doe");
    payloadResponseDTO.setFollowersCount(2);

    return payloadResponseDTO;
  }

  public static UserFollowedDTO createUserFollowed() {
    List<UserBasicDTO> followedExpectedDTO = List.of(
            new UserBasicDTO(4, "Eve Wilson"),
            new UserBasicDTO(5, "Charlie Brown"),
            new UserBasicDTO(2, "Alice Smith")
    );

    UserFollowedDTO payloadResponseDTO = new UserFollowedDTO();
    payloadResponseDTO.setId(1);
    payloadResponseDTO.setUserName("John Doe");
    payloadResponseDTO.setFollowed(followedExpectedDTO);

    return payloadResponseDTO;
  }

  public static PostsFollowedDTO PostsFollowedUsersEmpty() {
    PostsFollowedDTO payloadResponseDTO = new PostsFollowedDTO();
    payloadResponseDTO.setId(1);
    payloadResponseDTO.setPosts(List.of());

    return payloadResponseDTO;
  }

  public static UserFollowedDTO createUserFollowedIntegration() {
    List<UserBasicDTO> followedExpectedDTO = List.of(
            new UserBasicDTO(4, "Eve Wilson"),
            new UserBasicDTO(5, "Charlie Brown")
    );

    UserFollowedDTO payloadResponseDTO = new UserFollowedDTO();
    payloadResponseDTO.setId(1);
    payloadResponseDTO.setUserName("John Doe");
    payloadResponseDTO.setFollowed(followedExpectedDTO);

    return payloadResponseDTO;
  }
}
