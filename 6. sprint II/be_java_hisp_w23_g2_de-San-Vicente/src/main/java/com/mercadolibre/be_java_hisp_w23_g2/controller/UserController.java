package com.mercadolibre.be_java_hisp_w23_g2.controller;

import com.mercadolibre.be_java_hisp_w23_g2.dto.UserBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.MessageDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowedDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowersCountDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowersDTO;
import com.mercadolibre.be_java_hisp_w23_g2.service.IUserService;
import jakarta.validation.constraints.Positive;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling user-related operations.
 */
@RestController
@RequestMapping("/users")
@Validated
public class UserController {

  private final IUserService userService;

  public UserController(IUserService userService) {
    this.userService = userService;
  }

  /**
   * Endpoint for retrieving the count of followers for a specific user.
   *
   * @param userId The ID of the user whose followers count is to be retrieved.
   * @return ResponseEntity with the result of the getFollowersCountSeller operation.
   */
  @GetMapping("/{userId}/followers/count")
  public ResponseEntity<UserFollowersCountDTO> getFollowersCountSeller(
      @PathVariable @Positive(message = "El id debe ser mayor a cero") Integer userId) {
    return ResponseEntity.ok(userService.getFollowersCountSeller(userId));
  }

  /**
   * Endpoint for retrieving the list of followers for a specific user.
   *
   * @param userId The ID of the user whose followers list is to be retrieved.
   * @param order  Optional parameter for specifying the order of the followers list.
   * @return ResponseEntity with the result of the getFollowersUser operation.
   */
  @GetMapping("/{userId}/followers/list")
  public ResponseEntity<UserFollowersDTO> getFollowersUser(
      @PathVariable @Positive(message = "El id debe ser mayor a cero") Integer userId,
      @RequestParam(required = false) String order) {
    return ResponseEntity.ok(userService.getFollowersUser(userId, order));
  }

  /**
   * Endpoint for unfollowing a user.
   *
   * @param userId           The ID of the user who wants to unfollow another user.
   * @param userIdToUnfollow The ID of the user to be unfollowed.
   * @return ResponseEntity with the result of the unfollowUser operation.
   */
  @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
  public ResponseEntity<MessageDTO> unfollowUser(
      @PathVariable @Positive(message = "El id debe ser mayor a cero") Integer userId,
      @PathVariable @Positive(message = "El id debe ser mayor a cero") Integer userIdToUnfollow) {
    return ResponseEntity.ok(userService.unfollowUser(userId, userIdToUnfollow));
  }

  /**
   * Endpoint for retrieving the list of users followed by a specific user.
   *
   * @param userId The ID of the user whose followed users list is to be retrieved.
   * @param order  Optional parameter for specifying the order of the followed users list.
   * @return ResponseEntity with the result of the getFollowedUser operation.
   */
  @GetMapping("/{userId}/followed/list")
  public ResponseEntity<UserFollowedDTO> getFollowedUser(
      @PathVariable @Positive(message = "El id debe ser mayor a cero") Integer userId,
      @RequestParam(required = false) String order) {
    return ResponseEntity.ok(userService.getFollowedUser(userId, order));
  }

  /**
   * Endpoint for retrieving the list of all users. (Test)
   *
   * @return ResponseEntity with the result of the getAll operation.
   */
  @GetMapping("/all")
  public ResponseEntity<List<UserBasicDTO>> getAll() {
    return ResponseEntity.ok(userService.getAll());
  }

  /**
   * Endpoint for following a user.
   *
   * @param userId         The ID of the user who wants to follow another user.
   * @param userIdToFollow The ID of the user to be followed.
   * @return ResponseEntity with the result of the followUser operation.
   */
  @PostMapping("/{userId}/follow/{userIdToFollow}")
  public ResponseEntity<UserFollowedDTO> followUser(
      @PathVariable @Positive(message = "El id debe ser mayor a cero") Integer userId,
      @PathVariable @Positive(message = "El id debe ser mayor a cero") Integer userIdToFollow) {
    return ResponseEntity.ok(userService.followUser(userId, userIdToFollow));
  }
}
