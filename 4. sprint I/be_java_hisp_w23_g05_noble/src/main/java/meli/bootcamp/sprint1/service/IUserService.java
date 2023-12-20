package meli.bootcamp.sprint1.service;

import java.util.List;

import meli.bootcamp.sprint1.dto.request.NewPostDiscountDto;
import meli.bootcamp.sprint1.dto.request.NewPostDto;
import meli.bootcamp.sprint1.dto.request.UserFollowedDto;
import meli.bootcamp.sprint1.dto.response.*;

public interface IUserService {
  BaseResponseDto addPost(NewPostDto newPost);

  BaseResponseDto followUser(int userId, int userIdToFollow);

  List<UserDto> getAll();

  FollowersDto getFollowersByUserId(int userId);
  
  UserFollowedDto getFollowed(Integer id, String order);

  UserDtoUS0003 getFollowersById(int id, String order);

  BaseResponseDto unfollowUser(int userId, int userIdToUnfollow);

  LastPostsDto getLastPostsFromFollowed(int userId);

  LastPostsDto getLastPostsOrdered(int userId, String order);

  LastPostsDto getLastPosts(int userId, String order);

  UserFollowedDto getFollowed(Integer id);

  /////////////////////////////////////// US 10, 11 and 12 ///////////////////////////////////////
  BaseResponseDto postPromo(NewPostDiscountDto newPost);

  ProductsWithPromoDto productsWithPromoCount(int userId);

  ProductsDto allProductsWithPromo(int userId);

  UserPreferenceDto typesOfSellersFollowedByUser(int userId);
}
