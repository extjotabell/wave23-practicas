package meli.bootcamp.sprint1.service;

import meli.bootcamp.sprint1.dto.request.NewPostDto;
import meli.bootcamp.sprint1.dto.response.*;

public interface IUserService {
  BaseResponseDto addPost(NewPostDto post);

  BaseResponseDto followUser(int userId, int userIdToFollow);

  FollowersDto getFollowersByUserId(int userId);

  UserFollowedDto getFollowed(Integer id, String order);

  UserDto getFollowersById(int id, String order);

  BaseResponseDto unfollowUser(int userId, int userIdToUnfollow);

  LastPostsDto getLastPostsFromFollowed(int userId);

  LastPostsDto getLastPostsOrdered(int userId, String order);

  LastPostsDto getLastPosts(int userId, String order);
  US0011Dto countPromoPostByUserId(int userId);
  US0012Dto getProductsByPrice(Double since, Double to, int user_id);

}
