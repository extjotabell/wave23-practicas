package com.sprint.be_java_hisp_w23_g04.gateway;

import com.sprint.be_java_hisp_w23_g04.entity.User;

import java.util.List;

public interface IUserGateway {
    User findUser(Integer userId);
    List<User> getByIds(List<Integer> usersId);
    List<User> getAllUsers();
    void unfollowUser(int userId, int unfollowId);
}
