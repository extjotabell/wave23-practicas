package meli.bootcamp.sprint1.repository;

import java.util.List;

import meli.bootcamp.sprint1.entity.Category;
import meli.bootcamp.sprint1.entity.Post;
import meli.bootcamp.sprint1.entity.User;

public interface IGeneralRepository {
  User findUserById(int id);

  Category findCategoryById(int id);

  boolean unfollowUser(List<Integer> followedUsers, List<Integer> followers, int userIdToUnfollow, int removeFromFollowers);

  int getPromoProductsCount(int userId);

  List<Post> searchProductsByCategory(int categoryId);

  List<Post> getAllPosts();
}
