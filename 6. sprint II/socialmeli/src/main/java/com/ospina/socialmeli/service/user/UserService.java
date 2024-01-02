package com.ospina.socialmeli.service.user;

import com.ospina.socialmeli.dto.response.*;
import com.ospina.socialmeli.dto.response.FollowedListDTO;
import com.ospina.socialmeli.dto.response.FollowersCountDTO;
import com.ospina.socialmeli.dto.response.FollowersListDTO;
import com.ospina.socialmeli.dto.response.MessageResponseDTO;

public interface UserService {

    FollowersListDTO getFollowersList(Long userId, String order);

    FollowersCountDTO getFollowersCount(Long id);

    FollowedListDTO getFollowedSellersList(Long userID, String order);

    MessageResponseDTO followSeller(Long userId, Long userIdToFollow);

    MessageResponseDTO unfollowSeller(Long userId, Long userIdToUnfollow);
}
