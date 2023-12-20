package com.example.be_java_hisp_w23_g3.service.user;

import com.example.be_java_hisp_w23_g3.dto.request.UserRequestDTO;
import com.example.be_java_hisp_w23_g3.dto.response.*;

public interface UserService {

    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    FollowersListDTO getFollowersList(Long userId, String order);

    FollowersCountDTO getFollowersCount(Long id);

    FollowedListDTO getFollowedSellersList(Long userID, String order);

    MessageResponseDTO followSeller(Long userId, Long userIdToFollow);

    MessageResponseDTO unFollowSeller(Long userId, Long userIdToUnfollow);
}
