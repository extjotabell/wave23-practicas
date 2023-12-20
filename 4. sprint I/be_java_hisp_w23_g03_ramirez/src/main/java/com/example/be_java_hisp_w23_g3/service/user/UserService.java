package com.example.be_java_hisp_w23_g3.service.user;

import com.example.be_java_hisp_w23_g3.dto.response.*;
import com.example.be_java_hisp_w23_g3.entity.Seller;

import java.util.List;

public interface UserService {

    FollowersListDTO getFollowersList(Long userId, String order);

    FollowersCountDTO getFollowersCount(Long id);

    FollowedListDTO getFollowedSellersList(Long userID, String order);

    MessageResponseDTO followSeller(Long userId, Long userIdToFollow);

    MessageResponseDTO unFollowSeller(Long userId, Long userIdToUnfollow);

    List<PromoDTO> getMyPromos(Long userID);
}
