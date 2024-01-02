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
    private IUserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * US-0001: Allows the action of "Follow" to a specific seller.
     *
     * @param userId          The ID of the user initiating the follow action.
     * @param userIdToFollow  The ID of the user to be followed.
     * @return ResponseEntity representing the outcome of the follow action.
     */
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(
            @PathVariable
            @Min(message = "El id debe ser mayor a 0.", value = 1) int userId,
            @PathVariable
            @Min(message = "El id debe ser mayor a 0.", value = 1) int userIdToFollow
    ) {
        return ResponseEntity.ok(this.userService.followUser(userId, userIdToFollow));
    }

    /**
     * US-0002: Retrieves the count of users following a specific seller.
     *
     * @param userId The ID of the seller.
     * @return ResponseEntity with FollowersDto containing the count of followers.
     */
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<FollowersDto> getFollowers(
            @PathVariable
            @Min(message = "El id debe ser mayor a 0.", value = 1) int userId) {
        return ResponseEntity.ok(this.userService.getFollowersByUserId(userId));
    }

    /**
     * US-0003: Retrieves a list of all users following a specific seller (Who follows me?).
     *
     * @param id    The ID of the seller.
     * @param order Optional parameter for sorting the list.
     * @return ResponseEntity with UserDto representing the list of followers.
     */
    @GetMapping("/users/{id}/followers/list")
    public ResponseEntity<UserWFollowerListDto> getFollowersById(
            @PathVariable
            @Min(message = "El id debe ser mayor a 0.", value = 1) int id,
            @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getFollowersById(id, order), HttpStatus.OK);
    }

    /**
     * US-0004: Retrieves a list of all sellers followed by a specific user (Whom do I follow?).
     *
     * @param userId The ID of the user.
     * @param order  Optional parameter for sorting the list.
     * @return ResponseEntity representing the list of followed sellers.
     */
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<?> followedList(
            @PathVariable
            @Min(message = "El id debe ser mayor a 0.", value = 1) int userId,
            @RequestParam(required = false) String order) {
        return ResponseEntity.ok(this.userService.getFollowed(userId, order));
    }

    /**
     * US-0005: Creates a new product post.
     *
     * @param newPost NewPostDto containing information about the new post.
     * @return ResponseEntity with BaseResponseDto representing the outcome of the post creation.
     */
    @PostMapping("products/post")
    public ResponseEntity<BaseResponseDto> newPost(@Valid @RequestBody NewPostDto newPost) {
        return ResponseEntity.ok(this.userService.addPost(newPost));
    }

    /**
     * US-0006: Retrieves a list of posts made by the sellers that a user follows in the last two weeks.
     *
     * @param userId The ID of the user.
     * @param order  Optional parameter for sorting the list.
     * @return ResponseEntity with LastPostsDto representing the list of recent posts.
     */
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<LastPostsDto> lastPosts(
            @PathVariable
            @Min(message = "El id debe ser mayor a 0.", value = 1) int userId,
            @RequestParam(required = false, defaultValue = "date_desc") String order) {
        return ResponseEntity.ok(this.userService.getLastPosts(userId, order));
    }

    /**
     * US-0007: Allows the action of "Unfollow" (stop following) a specific seller.
     *
     * @param userId           The ID of the user initiating the unfollow action.
     * @param userIdToUnfollow The ID of the user to be unfollowed.
     * @return ResponseEntity with BaseResponseDto representing the outcome of the unfollow action.
     */
    @PostMapping("users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<BaseResponseDto> unfollowUser(
            @PathVariable
            @Min(message = "El id debe ser mayor a 0.", value = 1) int userId,
            @PathVariable
            @Min(message = "El id debe ser mayor a 0.", value = 1) int userIdToUnfollow) {
        return ResponseEntity.ok(this.userService.unfollowUser(userId, userIdToUnfollow));
    }

    /**
     * US-0008: Alphabetical ascending and descending sorting.
     * Note: This sorting applies only to US-003 and US-004.
     *
     * US-0009: Sorting by date in ascending and descending order.
     * Note: This sorting applies only to US-006.
     */

}