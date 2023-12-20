package com.meli.socialmeli.services;

import com.meli.socialmeli.dtos.response.MessageDTO;
import com.meli.socialmeli.dtos.response.FollowersCountDTO;
import com.meli.socialmeli.dtos.response.UserFollowersDTO;
import com.meli.socialmeli.dtos.response.UserResponseDTO;
import com.meli.socialmeli.dtos.response.UserFollowedDTO;
import com.meli.socialmeli.dtos.response.UserUnfollowDTO;
import com.meli.socialmeli.dtos.response.UserSellersSuggestedDTO;
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

    UserSellersSuggestedDTO getSuggestionsToFollow(int userId);
}