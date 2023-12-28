package meli.bootcamp.sprint1.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import meli.bootcamp.sprint1.dto.response.*;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import meli.bootcamp.sprint1.dto.request.NewPostDto;
import meli.bootcamp.sprint1.service.IUserService;
import meli.bootcamp.sprint1.service.impl.UserService;

@RestController
@Validated
public class UserController {
  private final IUserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("products/post")
  public ResponseEntity<BaseResponseDto> newPost(@Valid @RequestBody NewPostDto newPost) {
    return ResponseEntity.ok(this.userService.addPost(newPost));
  }

  @GetMapping("/users/{userId}/followers/count")
  public ResponseEntity<FollowersDto> getFollowers(
      @PathVariable @Min(message = "El id debe ser mayor a 0.", value = 1) int userId) {
    return ResponseEntity.ok(this.userService.getFollowersByUserId(userId));
  }

  @PostMapping("/users/{userId}/follow/{userIdToFollow}")
  public ResponseEntity<BaseResponseDto> followUser(
      @PathVariable @Min(message = "El id debe ser mayor a 0.", value = 1) int userId,
      @PathVariable @Min(message = "El id debe ser mayor a 0.", value = 1) int userIdToFollow) {
    return ResponseEntity.ok(this.userService.followUser(userId, userIdToFollow));
  }

  @GetMapping("/products/followed/{userId}/list")
  public ResponseEntity<LastPostsDto> lastPosts(
      @PathVariable @Min(message = "El id debe ser mayor a 0.", value = 1) int userId,
      @RequestParam(required = false, defaultValue = "date_desc") String order) {

    return ResponseEntity.ok(this.userService.getLastPosts(userId, order));
  }

  @GetMapping("/users/{userId}/followed/list")
  public ResponseEntity<UserWFollowedDto> followedList(
      @PathVariable @Min(message = "El id debe ser mayor a 0.", value = 1) int userId,
      @RequestParam(required = false) String order) {
    return ResponseEntity.ok(this.userService.getFollowed(userId, order));
  }

  @GetMapping("/users/{id}/followers/list")
  public ResponseEntity<UserWFollowerListDto> getFollowersById(
      @PathVariable @Min(message = "El id debe ser mayor a 0.", value = 1) int id,
      @RequestParam(required = false) String order) {
    return new ResponseEntity<>(userService.getFollowersById(id, order), HttpStatus.OK);
  }

  @PostMapping("users/{userId}/unfollow/{userIdToUnfollow}")
  public ResponseEntity<BaseResponseDto> unfollowUser(
      @PathVariable @Min(message = "El id debe ser mayor a 0.", value = 1) int userId,
      @PathVariable @Min(message = "El id debe ser mayor a 0.", value = 1) int userIdToUnfollow) {
    return ResponseEntity.ok(this.userService.unfollowUser(userId, userIdToUnfollow));
  }
}
