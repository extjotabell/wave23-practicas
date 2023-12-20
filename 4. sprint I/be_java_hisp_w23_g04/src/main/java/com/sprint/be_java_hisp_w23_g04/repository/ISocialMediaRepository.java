package com.sprint.be_java_hisp_w23_g04.repository;

import com.sprint.be_java_hisp_w23_g04.entity.User;

import java.util.List;

public interface ISocialMediaRepository {
    List<User> findAllUsers();

    User findUser(Integer userId);

    int getNextPostId(User user);

    void savePost(User user);

    void unfollowUser(int userId, int unfollowedUserId);
}
