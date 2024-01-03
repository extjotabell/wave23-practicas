package com.sprint.be_java_hisp_w23_g04.repository;

import com.sprint.be_java_hisp_w23_g04.entity.User;

import java.util.List;

public interface IUserMediaRepository {
    List<User> getAllUsers();

    User findUser(Integer userId);

    void unfollowUser(int userId, int unfollowedUserId);
    List<User> getByIds(List<Integer> listIds);
}
