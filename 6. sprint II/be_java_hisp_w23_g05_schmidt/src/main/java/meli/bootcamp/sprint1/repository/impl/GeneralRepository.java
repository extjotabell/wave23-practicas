package meli.bootcamp.sprint1.repository.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import meli.bootcamp.sprint1.entity.Category;
import meli.bootcamp.sprint1.entity.User;
import meli.bootcamp.sprint1.repository.IGeneralRepository;

@Repository
public class GeneralRepository implements IGeneralRepository {
  private final List<User> users;
  private List<Category> categories;

  public GeneralRepository() {
    this.categories = this.loadCategories();
    this.users = this.loadUsers();
  }

  private List<Category> loadCategories() {
    File file = null;
    try {
      file = ResourceUtils.getFile("classpath:static/categories.json");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    ObjectMapper objectMapper = new ObjectMapper();
    TypeReference<List<Category>> typeRef = new TypeReference<>() {
    };
    List<Category> categories = null;
    try {
      categories = objectMapper.readValue(file, typeRef);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return categories;
  }

  private List<User> loadUsers() {
    File file = null;
    try {
      file = ResourceUtils.getFile("classpath:static/users.json");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());
    TypeReference<List<User>> typeRef = new TypeReference<>() {
    };
    List<User> users = null;
    try {
      users = objectMapper.readValue(file, typeRef);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return users;
  }

  @Override
  public User findUserById(int id) {
    return this.users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
  }

  @Override
  public Category findCategoryById(int id) {
    return this.categories.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
  }

  @Override
  /*
    Method to stop following a user.
    @param userId User who is unfollowing someone. Their followed list is modified.
   * @param userIdToUnfollow User who is no longer being followed. Their followers list is modified.
   * @return boolean If the procedure was successful.
   */
  public boolean unfollowUser(int userId, int userIdToUnfollow) {
    User user = findUserById(userId);
    User userToUnfollow = findUserById(userIdToUnfollow);

    List<Integer> followedList = user.getFollowed();
    List<Integer> followersList = userToUnfollow.getFollowers();

    return followedList.removeIf(u -> u == userIdToUnfollow) && followersList.removeIf(u -> u == userId);
  }

  @Override
  public void addNewFollowed(int userId, int userIdToFollow) {
    User user = findUserById(userId);
    User userToFollow = findUserById(userIdToFollow);

    List<Integer> followedList = user.getFollowed();
    List<Integer> followersList = userToFollow.getFollowers();

    followedList.add(userIdToFollow);
    followersList.add(userId);
  }
}
