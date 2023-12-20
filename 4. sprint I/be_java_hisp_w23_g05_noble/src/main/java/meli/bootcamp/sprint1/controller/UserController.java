package meli.bootcamp.sprint1.controller;

import meli.bootcamp.sprint1.dto.request.NewPostDiscountDto;
import meli.bootcamp.sprint1.dto.response.*;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import meli.bootcamp.sprint1.dto.request.NewPostDto;
import meli.bootcamp.sprint1.service.IUserService;
import meli.bootcamp.sprint1.service.impl.UserService;

@RestController
public class UserController {
  private IUserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  /**
   * Get all users
   *
   * @return List UserDto
   */
  @GetMapping("test")
  public ResponseEntity<?> test(){
    return ResponseEntity.ok(this.userService.getAll());
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
  public ResponseEntity<UserDtoUS0003> getFollowersById(@PathVariable int id, @RequestParam(required = false) String order) {
    return new ResponseEntity<>(userService.getFollowersById(id, order), HttpStatus.OK);
  }
  
  @PostMapping ("users/{userId}/unfollow/{userIdToUnfollow}")
  public ResponseEntity<BaseResponseDto> unfollowUser (@PathVariable int userId, @PathVariable int userIdToUnfollow){
    return ResponseEntity.ok(this.userService.unfollowUser(userId, userIdToUnfollow));
  }

  /////////////////////////////////////// US 10, 11 and 12 ///////////////////////////////////////
  @PostMapping ("/products/promo-post")
  public ResponseEntity<BaseResponseDto> postPromo (@RequestBody NewPostDiscountDto newPost) {
    return ResponseEntity.ok(this.userService.postPromo(newPost));
  }

  @GetMapping ("/products/promo-post/count")
  public ResponseEntity<ProductsWithPromoDto> productsWithPromoCount(@RequestParam int user_id) {
    return ResponseEntity.ok(this.userService.productsWithPromoCount(user_id));
  }

  @GetMapping ("/products/promo-post/list")
  public  ResponseEntity<ProductsDto> allProductsWithPromo(@RequestParam int user_id) {
    return ResponseEntity.ok(this.userService.allProductsWithPromo(user_id));
  }

  @GetMapping ("/users/type-of-sellers/{userId}")
  public ResponseEntity<UserPreferenceDto> typesOfSellersFollowedByUser(@PathVariable int userId) {
    return ResponseEntity.ok(this.userService.typesOfSellersFollowedByUser(userId));
  }
}