package meli.bootcamp.sprint1.utils;

import meli.bootcamp.sprint1.dto.response.*;
import meli.bootcamp.sprint1.entity.Category;
import meli.bootcamp.sprint1.entity.Post;
import meli.bootcamp.sprint1.entity.Product;
import meli.bootcamp.sprint1.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Factory {

  public static LastPostsDto generateLastPostDto() {
    return new LastPostsDto(2, List.of(
        new PostDto(1, 1, LocalDate.now(),
            new ProductDto(1,
                "Tele",
                "Gamer",
                "Razer",
                "Red Black",
                "Special Edition"),
            1, 100.00),
        new PostDto(1, 2, LocalDate.of(2023, 12, 20),
            new ProductDto(1,
                "Tele",
                "Gamer",
                "Razer",
                "Red Black",
                "Special Edition"),
            1, 100.00),
        new PostDto(1, 3, LocalDate.of(2023, 12, 18),
            new ProductDto(1,
                "Tele",
                "Gamer",
                "Razer",
                "Red Black",
                "Special Edition"),
            1, 100.00)));

  }

  public static LastPostsDto generateLastPostDtoOrdered(String order) {

    List<PostDto> postDtoList = List.of(new PostDto(1, 1, LocalDate.now(),
        new ProductDto(1,
            "Tele",
            "Gamer",
            "Razer",
            "Red Black",
            "Special Edition"),
        1, 100.00),
        new PostDto(1, 2, LocalDate.of(2023, 12, 20),
            new ProductDto(1,
                "Tele",
                "Gamer",
                "Razer",
                "Red Black",
                "Special Edition"),
            1, 100.00),
        new PostDto(1, 3, LocalDate.of(2023, 12, 18),
            new ProductDto(1,
                "Tele",
                "Gamer",
                "Razer",
                "Red Black",
                "Special Edition"),
            1, 100.00));

    return new LastPostsDto(2, orderPostDtoList(postDtoList, order));

  }

  public static List<Post> generatePost() {
    Product product = new Product(1, "Tele", "Gamer", "Razer", "Special Edition", "Red Black");
    return List.of(
        new Post(product, LocalDate.now(), new Category(1, "Electronic"), 100.00),
        new Post(product, LocalDate.of(2023, 12, 20), new Category(1, "Electronic"), 100.00),
        new Post(product, LocalDate.of(2023, 12, 18), new Category(1, "Electronic"), 100.00),
        new Post(product, LocalDate.of(2022, 12, 18), new Category(1, "Electronic"), 100.00),
        new Post(product, LocalDate.of(2021, 12, 18), new Category(1, "Electronic"), 100.00));
  }

  public static User generateSeller() {
    return new User(1, "Nico", true, generatePost(), Collections.emptyList(), List.of(2));
  }

  public static User generateSeller(String order) {
    List<Post> orderedList = orderPostList(generatePost(), order);
    return new User(1, "Nico", true, orderedList, Collections.emptyList(), List.of(2));
  }

  public static User generateUser() {
    return new User(2, "Marco", false, Collections.emptyList(), List.of(1), Collections.emptyList());
  }

  public static User generateSellerNoFollowers() {
    return new User(3, "Tiago", true, generatePost(), Collections.emptyList(), Collections.emptyList());
  }

  public static User generateUser2() {
    return new User(4, "Fatima", false, Collections.emptyList(), List.of(1), List.of(1, 2));
  }

  public static UserWFollowerListDto generateUserDtoList(String order) {
    List<UserDto> userDtoList = new ArrayList<UserDto>();
    userDtoList.add(new UserDto(3, "Fatima Noble"));
    userDtoList.add(new UserDto(2, "Brenda Torrico"));
    userDtoList.add(new UserDto(1, "Ailen Pereira"));

    return new UserWFollowerListDto(4, "Geronimo Schmidt", orderUserDtoList(userDtoList, order));
  }

  public static List<User> generateUsersList() {
    return List.of(
        new User(1, "Ailen Pereira", true, Collections.emptyList(), Collections.emptyList(), Collections.emptyList()),
        new User(2, "Brenda Torrico", true, Collections.emptyList(), Collections.emptyList(), Collections.emptyList()),
        new User(3, "Fatima Noble", true, Collections.emptyList(), Collections.emptyList(), Collections.emptyList()),
        new User(4, "Geronimo Schmidt", true, Collections.emptyList(), Collections.emptyList(), List.of(1, 2, 3)));
  }

  private static List<UserDto> orderUserDtoList(List<UserDto> userDtoList, String order) {
    if (order == "name_asc") {
      return userDtoList.stream()
          .sorted(Comparator.comparing(UserDto::getUser_name))
          .toList();
    } else if (order == "name_desc") {
      return userDtoList.stream()
          .sorted(Comparator.comparing(UserDto::getUser_name).reversed())
          .toList();
    } else {
      return userDtoList;
    }
  }

  private static List<Post> orderPostList(List<Post> postList, String order) {
    if (order == "date_asc") {
      return postList.stream()
          .sorted(Comparator.comparing(Post::getDate))
          .toList();
    } else if (order == "name_desc") {
      return postList.stream()
          .sorted(Comparator.comparing(Post::getDate).reversed())
          .toList();
    } else {
      return postList;
    }
  }

  private static List<PostDto> orderPostDtoList(List<PostDto> postList, String order) {
    if (order == "date_asc") {
      return postList.stream()
          .sorted(Comparator.comparing(PostDto::getDate))
          .toList();
    } else if (order == "name_desc") {
      return postList.stream()
          .sorted(Comparator.comparing(PostDto::getDate).reversed())
          .toList();
    } else {
      return postList;
    }
  }
}
