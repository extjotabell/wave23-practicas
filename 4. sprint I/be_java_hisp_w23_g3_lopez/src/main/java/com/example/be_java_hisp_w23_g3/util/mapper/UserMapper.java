package com.example.be_java_hisp_w23_g3.util.mapper;

import com.example.be_java_hisp_w23_g3.dto.request.UserRequestDTO;
import com.example.be_java_hisp_w23_g3.dto.response.*;
import com.example.be_java_hisp_w23_g3.entity.Seller;
import com.example.be_java_hisp_w23_g3.entity.User;

import java.util.Comparator;
public class UserMapper {

    private static final String ORDER_NAME_ASC = "NAME_ASC";
    private static final String ORDER_NAME_DESC = "NAME_DESC";

    public static UserResponseDTO userToResponseDto(User user) {
        return new UserResponseDTO(user.getId(), user.getUsername());
    }

    public static User requestDtoToUser(UserRequestDTO userRequestDTO, Long id) {
        return User.build(id, userRequestDTO.getUserName());
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
                    .map(UserMapper::userToResponseDto).toList());

        if (ORDER_NAME_DESC.equalsIgnoreCase(order))
            return new FollowersListDTO(seller.getId(), seller.getUsername(), seller.getFollower().stream()
                    .sorted(Comparator.comparing(User::getUsername).reversed())
                    .map(UserMapper::userToResponseDto).toList());

        return new FollowersListDTO(seller.getId(), seller.getUsername(), seller.getFollower().stream()
                .map(UserMapper::userToResponseDto).toList());
    }
}
