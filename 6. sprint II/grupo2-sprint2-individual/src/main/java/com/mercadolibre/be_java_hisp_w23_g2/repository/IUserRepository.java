package com.mercadolibre.be_java_hisp_w23_g2.repository;

import com.mercadolibre.be_java_hisp_w23_g2.entity.Post;
import com.mercadolibre.be_java_hisp_w23_g2.entity.User;
import java.util.List;

public interface IUserRepository {

  User findUserById(int id);

  List<User> getAll();

  Post addPost(User user, Post post);

  User followUser(int userId, int userIdToFollow);

  User unfollowUser(User userId, User userIdToUnfollow);

}
