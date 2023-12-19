package meli.bootcamp.sprint1.service;

import meli.bootcamp.sprint1.dto.request.NewPostDto;
import meli.bootcamp.sprint1.dto.request.NewPromoPostDto;
import meli.bootcamp.sprint1.dto.request.UserFollowedDto;
import meli.bootcamp.sprint1.dto.response.BaseResponseDto;
import meli.bootcamp.sprint1.dto.response.UserDtoUS0003;
import meli.bootcamp.sprint1.dto.response.FollowersDto;
import meli.bootcamp.sprint1.dto.response.LastPostsDto;
import meli.bootcamp.sprint1.dto.response.PromoPostCountDto;

public interface IUserService {
  BaseResponseDto addPost(NewPostDto newPost);

  BaseResponseDto followUser(int userId, int userIdToFollow);

  FollowersDto getFollowersByUserId(int userId);

  UserFollowedDto getFollowed(Integer id, String order);

  UserDtoUS0003 getFollowersById(int id, String order);

  BaseResponseDto unfollowUser(int userId, int userIdToUnfollow);

  LastPostsDto getLastPostsFromFollowed(int userId);

  LastPostsDto getLastPostsOrdered(int userId, String order);

  LastPostsDto getLastPosts(int userId, String order);

  UserFollowedDto getFollowed(Integer id);

  BaseResponseDto addPromoPost(NewPromoPostDto newPromoPost);

  PromoPostCountDto countPromoPosts(int userId);

  BaseResponseDto remove(int userId);

}
