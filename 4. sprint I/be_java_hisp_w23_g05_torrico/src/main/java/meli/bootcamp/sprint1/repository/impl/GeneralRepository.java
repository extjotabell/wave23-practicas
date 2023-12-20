package meli.bootcamp.sprint1.repository.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import meli.bootcamp.sprint1.entity.Post;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import meli.bootcamp.sprint1.entity.Category;
import meli.bootcamp.sprint1.entity.User;
import meli.bootcamp.sprint1.repository.IGeneralRepository;

@Repository
public class GeneralRepository implements IGeneralRepository {
  private List<User> users;
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
    ObjectMapper objectMapper = new ObjectMapper();
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
  public boolean unfollowUser(List<Integer> followedUsers, List<Integer> followers, int userIdToUnfollow, int removeFromFollowers) {
    return followedUsers.removeIf(u -> u == userIdToUnfollow) && followers.removeIf(u -> u == removeFromFollowers);
  }

  @Override
  public int getPromoProductsCount(int userId) {
    User user = findUserById(userId);
    if (user != null) {
      return (int) user.getPosts().stream().filter(Post::isHasPromo).count();
    }
    return 0;
  }

  @Override
  public List<Post> searchProductsByCategory(int categoryId) {
    List<Post> postsByUsers= this.getAllPosts();

    return postsByUsers.stream().filter(post -> post.getCategory().getId() == categoryId).collect(Collectors.toList());
  }

  @Override
  public List<Post> getAllPosts() {
    return users.stream()
            .flatMap(user -> user.getPosts().stream())
            .toList();
  }
}
