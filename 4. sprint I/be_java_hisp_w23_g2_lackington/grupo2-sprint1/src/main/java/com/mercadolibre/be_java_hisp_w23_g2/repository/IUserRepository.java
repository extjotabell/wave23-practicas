package com.mercadolibre.be_java_hisp_w23_g2.repository;

import com.mercadolibre.be_java_hisp_w23_g2.entity.Post;
import com.mercadolibre.be_java_hisp_w23_g2.entity.User;

import java.util.List;
import java.util.function.Predicate;

public interface IUserRepository {
    User findUserById(int id);

    List<User> getAll();

    void addPost(User user, Post post);

    User followUser(int userId, int userIdToFollow);

    void unfollowUser(User userId, User userIdToUnfollow);

    int countPromoProduct(int id);

    List<Post> filterPriceProduct(double min, double max);

}
