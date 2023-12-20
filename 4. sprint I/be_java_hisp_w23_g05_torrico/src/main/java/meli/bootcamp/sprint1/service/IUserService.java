package meli.bootcamp.sprint1.service;

import meli.bootcamp.sprint1.dto.request.NewPostDto;
import meli.bootcamp.sprint1.dto.request.NewPromoPostDto;
import meli.bootcamp.sprint1.dto.response.*;

import java.util.List;

public interface IUserService {
  BaseResponseDto addPost(NewPostDto newPost);

  BaseResponseDto followUser(int userId, int userIdToFollow);

  FollowersDto getFollowersByUserId(int userId);

  UserFollowedDto getFollowed(Integer id, String order);

  UserDto getFollowersById(int id, String order);

  BaseResponseDto unfollowUser(int userId, int userIdToUnfollow);

  LastPostsDto getLastPostsFromFollowed(int userId);

  LastPostsDto getLastPostsOrdered(int userId, String order);

  LastPostsDto getLastPosts(int userId, String order);

  BaseResponseDto  addPromoPost(NewPromoPostDto newPromoPost);
  PromoPostsDto getPromoProductsCount(int userId);
  List<ProductSearchResponseDto> searchProductsByCategory(int categoryId);


}
