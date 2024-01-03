package com.sprint.be_java_hisp_w23_g04.controller;

import com.sprint.be_java_hisp_w23_g04.exception.NoContentException;
import com.sprint.be_java_hisp_w23_g04.exception.NotFoundException;
import com.sprint.be_java_hisp_w23_g04.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/users")
public class UserMeliController {
    private final IUserMediaService userMediaService;

    public UserMeliController(UserMediaServiceImpl userMediaService) {
        this.userMediaService = userMediaService;
    }

    /**
     * Get all users, returns all system users.
     *
     * @return A ResponseEntity containing list of users.
     */
    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userMediaService.getAllUsers(), HttpStatus.OK);
    }

    /**
     * User follows Seller, Seller adds new Follower and User add new Followed.
     *
     * @param userId The ID of the User who adds new Followed.
     * @param userIdToFollow  The ID of the Seller who adds new Follower.
     * @return A ResponseEntity containing the success message.
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followSellerUser(
            @PathVariable @Positive(message = "El id debe ser mayor a cero") Integer userId,
            @PathVariable @Positive(message = "El id debe ser mayor a cero") Integer userIdToFollow) {
        return new ResponseEntity<>(userMediaService.followSellerUser(userId, userIdToFollow), HttpStatus.OK);
    }

    /**
     * Retrieve the Count of Followers for a Specific User.
     * <p>
     * This endpoint provides the total number of followers for a user based on their unique userId.
     * It serves as a means to quickly gauge the user's social influence by quantifying their follower base.
     *
     * @param userId The ID of the user whose followers count is being queried.
     * @return A ResponseEntity containing the numerical count of followers for the user.
     * @throws NotFoundException If the user with the given userId does not exist.
     */
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getFollowers(
            @PathVariable @Positive(message = "El id del usuario debe ser mayor a cero") int userId) {
        return new ResponseEntity<>(userMediaService.followersCount(userId), HttpStatus.OK);
    }

    /**
     * US-0003 Return all followers of a user.
     * <p>
     * With the order parameter we can sort them descendingly and ascendingly.
     *
     * @param userId The ID of the user whose followers are to be retried.
     * @param order  The shorting criteria for the returned list. Defaults to 'name_asc'.
     * @return A ResponseEntity containing the sorted list of followers
     * @throws NotFoundException  If the user with the given userId does not exist.
     * @throws NoContentException If the user exists but no have followers.
     */
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getAllFollowersByUserId(
            @PathVariable @Positive(message = "El id del usuario debe ser mayor a cero") Integer userId,
            @RequestParam(defaultValue = "name_asc") String order) {
        return new ResponseEntity<>(userMediaService.getFollowersByUserId(userId, order), HttpStatus.OK);
    }

    /**
     * Retrieves a list of sellers followed by a given user, sorted based on the specified order.
     *
     * @param userId The ID of the user whose followed sellers are to be retrieved.
     * @param order  The sorting criteria for the returned list (e.g., 'name_asc'). Defaults to 'name_asc'.
     * @return A ResponseEntity containing the sorted list of followed sellers or 204 No Content if none are followed.
     * @throws NotFoundException  If the user with the given userId does not exist.
     * @throws NoContentException If the user exists but follows no sellers.
     */
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> getFollowedByUserId(
            @PathVariable @Positive(message = "El id del usuario debe ser mayor a cero") Integer userId,
            @RequestParam(defaultValue = "name_asc") String order) {
        return new ResponseEntity<>(userMediaService.getFollowedByUserId(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(
            @PathVariable @Positive(message = "El id del usuario debe ser mayor a cero") int userId,
            @PathVariable @Positive(message = "El id del usuario debe ser mayor a cero") int userIdToUnfollow) {
        return new ResponseEntity<>(userMediaService.unfollowUser(userId, userIdToUnfollow), HttpStatus.ACCEPTED);
    }
}
