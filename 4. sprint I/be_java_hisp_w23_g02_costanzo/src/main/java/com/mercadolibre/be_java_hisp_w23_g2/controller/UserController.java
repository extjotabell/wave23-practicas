package com.mercadolibre.be_java_hisp_w23_g2.controller;

import com.mercadolibre.be_java_hisp_w23_g2.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling user-related operations.
 */
@RestController
@RequestMapping("/users")
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
    public ResponseEntity<?> getFollowersCountSeller(@PathVariable int userId) {
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
    public ResponseEntity<?> getFollowersUser(@PathVariable int userId, @RequestParam(required = false) String order) {
        return ResponseEntity.ok(userService.getFollowersUser(userId, order));
    }

    /**
     * Endpoint for unfollowing a user.
     *
     * @param userId          The ID of the user who wants to unfollow another user.
     * @param userIdToUnfollow The ID of the user to be unfollowed.
     * @return ResponseEntity with the result of the unfollowUser operation.
     */
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow){
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
    public ResponseEntity<?> getFollowedUser(@PathVariable int userId, @RequestParam(required = false) String order) {
        return ResponseEntity.ok(userService.getFollowedUser(userId, order));
    }

    /**
     * Endpoint for retrieving the list of all users. (Test)
     *
     * @return ResponseEntity with the result of the getAll operation.
     */
    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    /**
     * Endpoint for following a user.
     *
     * @param userId        The ID of the user who wants to follow another user.
     * @param userIdToFollow The ID of the user to be followed.
     * @return ResponseEntity with the result of the followUser operation.
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable int userId,@PathVariable int userIdToFollow){
        return new ResponseEntity<>(userService.followUser(userId,userIdToFollow),HttpStatus.OK);
    }

    /**
     * Endpoint for retrieving the list of users who do not follow me back.
     *
     * @param userId The ID of the user who wants to follow another user.
     * @return ResponseEntity with the result of the followedNotFollowers operation.
     */
    @GetMapping("/followedNotFollowers/{userId}")
    public ResponseEntity<?> followedNotFollowers(@PathVariable int userId) {
        return new ResponseEntity<>(userService.followedNotFollowers(userId), HttpStatus.OK);
    }
}
