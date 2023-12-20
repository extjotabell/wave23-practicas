package com.ospina.socialmeli.util;

import com.ospina.socialmeli.dto.response.*;
import com.ospina.socialmeli.entity.Seller;
import com.ospina.socialmeli.entity.User;

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
                    .map(SellerMapper::mapToDTO).toList());

        if (ORDER_NAME_DESC.equalsIgnoreCase(order))
            return new FollowedListDTO(user.getId(), user.getUsername(), user.getFollowing().stream()
                    .sorted(Comparator.comparing(User::getUsername).reversed())
                    .map(SellerMapper::mapToDTO).toList());

        return new FollowedListDTO(user.getId(), user.getUsername(), user.getFollowing().stream()
                .map(SellerMapper::mapToDTO).toList());
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

        return new FollowersListDTO(seller.getId(), seller.getUsername(), seller.getFollower().stream()
                .map(UserMapper::mapToDTO).toList());
    }
}
