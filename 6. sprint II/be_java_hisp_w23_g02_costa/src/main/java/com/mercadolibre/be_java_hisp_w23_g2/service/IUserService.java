package com.mercadolibre.be_java_hisp_w23_g2.service;

import com.mercadolibre.be_java_hisp_w23_g2.dto.UserBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.MessageDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.PostsFollowedDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowedDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowersCountDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowersDTO;
import java.util.List;

public interface IUserService {

  UserFollowersCountDTO getFollowersCountSeller(Integer userId);

  List<UserBasicDTO> getAll();

  UserFollowedDTO followUser(Integer userId, Integer userIdToFollow);

  MessageDTO unfollowUser(Integer userId, Integer userIdToUnfollow);

  UserFollowersDTO getFollowersUser(Integer userId, String sortType);

  UserFollowedDTO getFollowedUser(Integer userId, String sortType);

  PostsFollowedDTO getPostsByFollowedUsers(Integer userId, String sortType);
}
