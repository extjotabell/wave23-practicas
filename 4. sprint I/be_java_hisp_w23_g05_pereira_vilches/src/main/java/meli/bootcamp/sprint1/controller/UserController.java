package meli.bootcamp.sprint1.controller;

import meli.bootcamp.sprint1.dto.response.*;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import meli.bootcamp.sprint1.dto.request.NewPostDto;
import meli.bootcamp.sprint1.service.IUserService;
import meli.bootcamp.sprint1.service.impl.UserService;

@RestController
public class UserController {
  private final IUserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("test")
  public ResponseEntity<?> getAll(){
    return ResponseEntity.ok(this.userService.getAll());
  }

  @PostMapping("products/post")
  public ResponseEntity<BaseResponseDto> newPost(@RequestBody NewPostDto newPost){
    return ResponseEntity.ok(this.userService.addPost(newPost));
  }

  @GetMapping("/users/{userId}/followers/count")
  public ResponseEntity<FollowersCountDto> getFollowers(@PathVariable int userId){
    return ResponseEntity.ok(this.userService.getFollowersByUserId(userId));
  }

  @PostMapping("/users/{userId}/follow/{userIdToFollow}")
  public ResponseEntity<?> followUser(@PathVariable int userId, @PathVariable int userIdToFollow){
    return ResponseEntity.ok(this.userService.followUser(userId,userIdToFollow));
  }

  @GetMapping("/products/followed/{userId}/list")
  public ResponseEntity<LastPostsDto> lastPosts(@PathVariable int userId,
                                                @RequestParam(required = false, defaultValue = "date_desc") String order){
    return ResponseEntity.ok(this.userService.getLastPosts(userId, order));
  }

  @GetMapping("/users/{userId}/followed/list")
  public ResponseEntity<?> followedList(@PathVariable int userId, @RequestParam(required = false) String order){
    return ResponseEntity.ok(this.userService.getFollowed(userId, order));
  }

  @GetMapping("/users/{id}/followers/list")
  public ResponseEntity<UserFollowersDto> getFollowersById(@PathVariable int id, @RequestParam(required = false) String order) {
    return new ResponseEntity<>(userService.getFollowersById(id, order), HttpStatus.OK);
  }

  @PostMapping ("users/{userId}/unfollow/{userIdToUnfollow}")
  public ResponseEntity<BaseResponseDto> unfollowUser (@PathVariable int userId, @PathVariable int userIdToUnfollow){
    return ResponseEntity.ok(this.userService.unfollowUser(userId, userIdToUnfollow));
  }

  @PostMapping("/products/promo-post")
  public ResponseEntity<BaseResponseDto> newPromoPost(@RequestBody NewPostDto newPost){
    return ResponseEntity.ok(this.userService.addPost(newPost));
  }

  @GetMapping("/products/promo-post/count")
  public ResponseEntity<PromoProductsDto> getPostWithPromo(@RequestParam int user_id){
    return ResponseEntity.ok(this.userService.getPostWithPromo(user_id));
  }

  //BONUS:
  @PostMapping("/posts/{userId}/favorites/{postId}")
  public ResponseEntity<?> addToFavorites(@PathVariable int userId,
                                          @PathVariable int postId){
    return ResponseEntity.ok(this.userService.addPostToFavorites(userId,postId));
  }
}
