package com.meli.socialmeli.services;

import com.meli.socialmeli.dtos.response.*;
import com.meli.socialmeli.entities.User;

import java.util.List;

public interface IUserService {
    List<User> findFollowsByIdProductService(int userId);
    UserFollowersDTO findFollowersById(int id, String order);
    List<UserResponseDTO> findAll();
    MessageDTO followSeller(int userId, int userIdToFollow);
    FollowersCountDTO getFollowersCount(int userId);
    UserFollowedDTO findFollowedById(int userId, String order);

    UserUnfollowDTO unfollowUser(int userId, int userIdToUnfollow);

    UserDeleteDTO deleteUser(int userId);
}