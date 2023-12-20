package com.example.be_java_hisp_w23_g3.util.mapper;

import com.example.be_java_hisp_w23_g3.dto.request.UserRequestDTO;
import com.example.be_java_hisp_w23_g3.dto.response.*;
import com.example.be_java_hisp_w23_g3.entity.user.Seller;
import com.example.be_java_hisp_w23_g3.entity.user.User;

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

    public static FollowedListResponseDTO mapToFollowedListDTO(User user, String order) {
        if (ORDER_NAME_ASC.equalsIgnoreCase(order))
            return new FollowedListResponseDTO(user.getId(), user.getUsername(), user.getFollowing().stream()
                    .sorted(Comparator.comparing(User::getUsername))
                    .map(SellerMapper::mapToDTO).toList());

        if (ORDER_NAME_DESC.equalsIgnoreCase(order))
            return new FollowedListResponseDTO(user.getId(), user.getUsername(), user.getFollowing().stream()
                    .sorted(Comparator.comparing(User::getUsername).reversed())
                    .map(SellerMapper::mapToDTO).toList());

        return new FollowedListResponseDTO(user.getId(), user.getUsername(), user.getFollowing().stream()
                .map(SellerMapper::mapToDTO).toList());
    }

    public static FollowersListResponseDTO mapToFollowersListDTO(Seller seller, String order) {
        if (ORDER_NAME_ASC.equalsIgnoreCase(order))
            return new FollowersListResponseDTO(seller.getId(), seller.getUsername(), seller.getFollower().stream()
                    .sorted(Comparator.comparing(User::getUsername))
                    .map(UserMapper::userToResponseDto).toList());

        if (ORDER_NAME_DESC.equalsIgnoreCase(order))
            return new FollowersListResponseDTO(seller.getId(), seller.getUsername(), seller.getFollower().stream()
                    .sorted(Comparator.comparing(User::getUsername).reversed())
                    .map(UserMapper::userToResponseDto).toList());

        return new FollowersListResponseDTO(seller.getId(), seller.getUsername(), seller.getFollower().stream()
                .map(UserMapper::userToResponseDto).toList());
    }
}
