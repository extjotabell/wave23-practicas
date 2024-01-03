package com.mercadolibre.be_java_hisp_w23_g2.utils;

import com.mercadolibre.be_java_hisp_w23_g2.dto.ProductBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.UserBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.requests.PostDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowedDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowersCountDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowersDTO;
import com.mercadolibre.be_java_hisp_w23_g2.entity.Post;
import com.mercadolibre.be_java_hisp_w23_g2.entity.Product;
import com.mercadolibre.be_java_hisp_w23_g2.entity.User;
import java.time.LocalDate;
import java.util.List;

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

  public static ProductBasicDTO createProductBasicDTO() {
    return new ProductBasicDTO(5,"Silla Gamer","Gamer","Racer","Red and Black","Special Edition");
  }

  public static PostDTO createPostDTO() {
    return new PostDTO(1, LocalDate.of(2024, 2, 2), createProductBasicDTO(), 100,1500.50);
  }

  public static ProductBasicDTO createProductBasicDTOExists() {
    return new ProductBasicDTO(201,"Laptop Pro","Electronics","TechMaster","Silver","Powerful laptop for professionals");
  }

  public static PostDTO createPostDTOExists() {
    return new PostDTO(1, LocalDate.of(2023, 1, 15),createProductBasicDTOExists(),100,1200.00);
  }

  public static UserFollowersCountDTO createUserFollowersCountDTO() {
    return new UserFollowersCountDTO(10,"Noah Miller",2);
  }

  public static UserFollowersDTO createUserFollowersDTO() {
    return  new UserFollowersDTO(1,"John Doe",List.of(
            new UserBasicDTO(2, "Alice Smith"),new UserBasicDTO(3, "Bob Jones")));
  }

  public static UserFollowedDTO createUserFollowedDTOdesc() {
    return  new UserFollowedDTO(1,"John Doe", List.of(new UserBasicDTO(4, "Eve Wilson"),
            new UserBasicDTO(5, "Charlie Brown")));


  }

  public static UserFollowedDTO createUserFollowedDTOasc() {
    return  new UserFollowedDTO(1,"John Doe", List.of(
            new UserBasicDTO(5, "Charlie Brown"),new UserBasicDTO(4, "Eve Wilson")));


  }

  public static UserFollowedDTO createUserFollowedDTO() {
    return  new UserFollowedDTO(2,"Alice Smith", List.of(new UserBasicDTO(4, "Eve Wilson"),
            new UserBasicDTO(5, "Charlie Brown"),new UserBasicDTO(15, "Mia Wright")));


  }
}
