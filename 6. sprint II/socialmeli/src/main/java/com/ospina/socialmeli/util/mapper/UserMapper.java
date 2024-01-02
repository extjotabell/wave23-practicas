package com.ospina.socialmeli.util.mapper;

import com.ospina.socialmeli.dto.response.UserDTO;
import com.ospina.socialmeli.entity.user.Seller;
import com.ospina.socialmeli.entity.user.User;
import com.ospina.socialmeli.exception.exceptions.InvalidOrderException;
import com.ospina.socialmeli.dto.response.FollowedListDTO;
import com.ospina.socialmeli.dto.response.FollowersListDTO;

import java.util.Comparator;
public class UserMapper {

    private static final String ORDER_NAME_ASC = "NAME_ASC";
    private static final String ORDER_NAME_DESC = "NAME_DESC";

    public static UserDTO mapToDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername());
    }

    public static FollowedListDTO mapToFollowedListDTO(User user, String order) {
        if (ORDER_NAME_ASC.equalsIgnoreCase(order))
            return new FollowedListDTO(user.getId(), user.getUsername(), user.getFollowing().stream()
                    .sorted(Comparator.comparing(User::getUsername))
                    .map(UserMapper::mapToDTO).toList());

        if (ORDER_NAME_DESC.equalsIgnoreCase(order))
            return new FollowedListDTO(user.getId(), user.getUsername(), user.getFollowing().stream()
                    .sorted(Comparator.comparing(User::getUsername).reversed())
                    .map(UserMapper::mapToDTO).toList());

        if (order != null)
            throw new InvalidOrderException(
                    "The 'order' parameter is invalid. The permitted values are 'name_asc' or 'name_desc'.");

        return new FollowedListDTO(user.getId(), user.getUsername(), user.getFollowing().stream()
                .map(UserMapper::mapToDTO).toList());
    }

    public static FollowersListDTO mapToFollowersListDTO(Seller seller, String order) {
        if (ORDER_NAME_ASC.equalsIgnoreCase(order))
            return new FollowersListDTO(seller.getId(), seller.getUsername(), seller.getFollower().stream()
                    .sorted(Comparator.comparing(User::getUsername))
                    .map(UserMapper::mapToDTO).toList());

        if (ORDER_NAME_DESC.equalsIgnoreCase(order))
            return new FollowersListDTO(seller.getId(), seller.getUsername(), seller.getFollower().stream()
                    .sorted(Comparator.comparing(User::getUsername).reversed())
                    .map(UserMapper::mapToDTO).toList());

        if (order != null)
            throw new InvalidOrderException(
                    "The 'order' parameter is invalid. The permitted values are 'name_asc' or 'name_desc'.");

        return new FollowersListDTO(seller.getId(), seller.getUsername(), seller.getFollower().stream()
                .map(UserMapper::mapToDTO).toList());
    }
}
