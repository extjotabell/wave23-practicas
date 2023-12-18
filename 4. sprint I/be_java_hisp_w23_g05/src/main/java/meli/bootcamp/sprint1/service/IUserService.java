package meli.bootcamp.sprint1.service;

import java.util.List;

import meli.bootcamp.sprint1.dto.request.FollowedDto;
import meli.bootcamp.sprint1.dto.request.NewPostDto;
import meli.bootcamp.sprint1.dto.request.UserFollowedDto;
import meli.bootcamp.sprint1.dto.response.BaseResponseDto;
import meli.bootcamp.sprint1.dto.response.UserDtoUS0003;
import meli.bootcamp.sprint1.dto.response.FollowersDto;
import meli.bootcamp.sprint1.dto.response.LastPostsDto;
import meli.bootcamp.sprint1.entity.User;

public interface IUserService {
  BaseResponseDto addPost(NewPostDto newPost);

  BaseResponseDto followUser(int userId, int userIdToFollow);

  //Cambiar a UserDto
  List<User> getAll();

  FollowersDto getFollowersByUserId(int userId);
  
  UserFollowedDto getFollowed(Integer id, String order);

  UserDtoUS0003 getFollowersById(int id, String order);

  BaseResponseDto unfollowUser(int userId, int userIdToUnfollow);

  LastPostsDto getLastPostsFromFollowed(int userId);

  LastPostsDto getLastPostsOrdered(int userId, String order);

  LastPostsDto getLastPosts(int userId, String order);
  
  UserFollowedDto getFollowed(Integer id);

}
