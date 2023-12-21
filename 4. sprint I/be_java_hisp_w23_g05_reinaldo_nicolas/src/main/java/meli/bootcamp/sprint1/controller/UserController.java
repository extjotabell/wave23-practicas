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

  @PostMapping("products/promo-post")
  public ResponseEntity<BaseResponseDto> newPromoPost(@RequestBody NewPostDto newPost){
    return ResponseEntity.ok(this.userService.addPromoPost(newPost));
  }

  @GetMapping("products/promo-post/count")
  public ResponseEntity<PromoPostDto> getPromosUser(@RequestParam int user_id){
    return ResponseEntity.ok(this.userService.getPromoPost(user_id));
  }

  /*
   * US 0012: Obtener la cantidad de post que tiene el usuario de determinada categoria
   *
   * Method: GET
   * SIGN: user/post/{categoryId}/{userId}
   * RESPONSE:
   * {
    "user_id": 1,
    "user_name": "Ailen Pereira",
    "category": "Home Decor",
    "category_post_count": 4
    }
    * PARAMETROS:
    * categoryId= El identificador de la categoria
    * userId= El identificador del usuario
   * */

  @GetMapping("user/post/{categoryId}/{userId}")
  public ResponseEntity<CategoryCountDto> getCountCategoryUser(
          @PathVariable int categoryId,
          @PathVariable int userId){
    return ResponseEntity.ok(this.userService.getCountCategoryUser(categoryId,userId));
  }
}
