package meli.bootcamp.sprint1.repository;

import meli.bootcamp.sprint1.entity.Category;
import meli.bootcamp.sprint1.entity.User;

public interface IGeneralRepository {
  User findUserById(int id);

  Category findCategoryById(int id);

  boolean unfollowUser(int userId, int userIdToUnfollow);

  void addNewFollowed(int userId, int userIdToFollow);
}
