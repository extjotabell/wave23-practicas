package meli.bootcamp.sprint1.controller;

import meli.bootcamp.sprint1.dto.response.UserDto;
import org.springframework.http.HttpStatus;
import meli.bootcamp.sprint1.dto.response.FollowersDto;
import meli.bootcamp.sprint1.dto.response.LastPostsDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import meli.bootcamp.sprint1.dto.request.NewPostDto;
import meli.bootcamp.sprint1.dto.response.BaseResponseDto;
import meli.bootcamp.sprint1.service.IUserService;
import meli.bootcamp.sprint1.service.impl.UserService;

@RestController
public class UserController {
  private IUserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("products/post")
  public ResponseEntity<BaseResponseDto> newPost(@RequestBody NewPostDto newPost){
    return ResponseEntity.ok(this.userService.addPost(newPost));
  }

  @GetMapping("/users/{userId}/followers/count")
  public ResponseEntity<FollowersDto> getFollowers(@PathVariable int userId){
    return ResponseEntity.ok(this.userService.getFollowersByUserId(userId));
  }

  @PostMapping("/users/{userId}/follow/{userIdToFollow}")
  public ResponseEntity<?> followUser(
          @PathVariable int userId,
          @PathVariable int userIdToFollow
  ){
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
  public ResponseEntity<UserDto> getFollowersById(@PathVariable int id, @RequestParam(required = false) String order) {
    return new ResponseEntity<>(userService.getFollowersById(id, order), HttpStatus.OK);
  }
  
  @PostMapping ("users/{userId}/unfollow/{userIdToUnfollow}")
  public ResponseEntity<BaseResponseDto> unfollowUser (@PathVariable int userId, @PathVariable int userIdToUnfollow){
    return ResponseEntity.ok(this.userService.unfollowUser(userId, userIdToUnfollow));
  }

  @PostMapping("/product/promo-post")
  public ResponseEntity<BaseResponseDto> addPromoPost(@RequestBody NewPostDto NewPostDto){
    return ResponseEntity.ok(this.userService.addPromoPost(NewPostDto));
  }

  @GetMapping("/products/promo-post/count")
  public ResponseEntity<?> getPromoPostCount(@RequestParam Integer user_id){
    return new ResponseEntity<>(this.userService.getProductsPromoCountById(user_id), HttpStatus.OK);
  }

  @GetMapping("/products/promo-post/list")
  public ResponseEntity<?> getPromoPostList(@RequestParam Integer user_id, @RequestParam(required = false, defaultValue = "name_desc") String order){
    return new ResponseEntity<>(this.userService.getListProductsById(user_id, order), HttpStatus.OK);
  }

}
