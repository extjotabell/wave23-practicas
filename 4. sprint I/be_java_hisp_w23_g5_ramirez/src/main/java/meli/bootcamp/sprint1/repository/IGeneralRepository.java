package meli.bootcamp.sprint1.repository;

import meli.bootcamp.sprint1.entity.Category;
import meli.bootcamp.sprint1.entity.User;

public interface IGeneralRepository {
  User findUserById(int id);

  Category findCategoryById(int id);

  boolean removeUser(User user);
}
