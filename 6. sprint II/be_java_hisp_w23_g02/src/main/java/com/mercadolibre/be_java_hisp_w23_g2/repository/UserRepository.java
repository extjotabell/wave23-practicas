package com.mercadolibre.be_java_hisp_w23_g2.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.be_java_hisp_w23_g2.entity.Post;
import com.mercadolibre.be_java_hisp_w23_g2.entity.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

/**
 * Repository class for handling user-related operations.
 */
@Repository
public class UserRepository implements IUserRepository {

  private final List<User> users;
  private Integer lastPostId;

  public UserRepository() throws IOException {
    users = loadData();

    lastPostId = users.stream()
        .flatMap(user -> user.getPosts().stream())
        .mapToInt(Post::getId)
        .reduce(0, Integer::max);
  }

  /**
   * Finds a user by their ID.
   *
   * @param id The ID of the user to find.
   * @return The User object with the specified ID, or null if not found.
   */
  @Override
  public User findUserById(int id) {
    return users
        .stream()
        .filter(user -> user.getId() == id)
        .findFirst()
        .orElse(null);
  }

  /**
   * Retrieves a list of all users. (Test)
   *
   * @return List of all users.
   */
  @Override
  public List<User> getAll() {
    return users;
  }

  /**
   * Adds a post to a user's list of posts.
   *
   * @param user The user to add the post to.
   * @param post The post to be added.
   */
  @Override
  public Post addPost(User user, Post post) {
    post.setId(++lastPostId);
    user.getPosts().add(post);
    return post;
  }

  /**
   * Follows a user by adding them to the followed list.
   *
   * @param userId         The ID of the user initiating the follow.
   * @param userIdToFollow The ID of the user to be followed.
   * @return The updated User object after the follow operation.
   */
  @Override
  public User followUser(int userId, int userIdToFollow) {
    User user = findUserById(userId);
    User user1 = findUserById(userIdToFollow);

    user.getFollowed().add(user1);
    user1.getFollowers().add(user);
    return user;
  }

  /**
   * Unfollows a user by removing them from the followed list.
   *
   * @param currentUser    The user initiating the unfollow.
   * @param userToUnfollow The user to be unfollowed.
   */
  @Override
  public User unfollowUser(User currentUser, User userToUnfollow) {
    currentUser.getFollowed().remove(userToUnfollow);
    userToUnfollow.getFollowers().remove(currentUser);
    return userToUnfollow;
  }

  /**
   * Loads user data from a JSON file.
   *
   * @return List of User objects loaded from the JSON file.
   * @throws IOException If an I/O error occurs while reading the JSON file.
   */
  public List<User> loadData() throws IOException {
    File file = null;
    try {
      file = ResourceUtils.getFile("src/main/resources/users.json");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    ObjectMapper objectMapper = new ObjectMapper();
    TypeReference<List<User>> typeRef = new TypeReference<>() {
    };
    List<User> usersList = null;
    try {
      usersList = objectMapper.readValue(file, typeRef);
      //JSON data is being mapped so that repeated users are nor created
      for (User user : usersList) {
        for (int j = 0; j < user.getFollowers().size(); j++) {
          List<User> finalUsers = List.copyOf(usersList);
          user.setFollowers(user.getFollowers().stream().map(u -> finalUsers
                  .stream().filter(u1 -> u.getId().equals(u1.getId())).findFirst().orElse(null))
              .collect(Collectors.toList()));
        }
        for (int j = 0; j < user.getFollowed().size(); j++) {
          List<User> finalUsers = List.copyOf(usersList);
          user.setFollowed(user.getFollowed().stream().map(u -> finalUsers
                  .stream().filter(u1 -> u.getId().equals(u1.getId())).findFirst().orElse(null))
              .collect(Collectors.toList()));
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return usersList;
  }
}
