package com.example.be_java_hisp_w23_g3.controller;

import com.example.be_java_hisp_w23_g3.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w23_g3.dto.response.MessageResponseDTO;
import com.example.be_java_hisp_w23_g3.service.user.UserService;

import com.example.be_java_hisp_w23_g3.dto.response.FollowersListDTO;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersListDTO> getFollowersList(
        @PathVariable("userId") @Positive(message = "The user_id must be greater than zero") Long userId,
        @RequestParam(required = false) @Pattern(regexp = "^(?i)(NAME_ASC|NAME_DESC)$", message = "Order field can only be NAME_ASC or NAME_DESC") String order
    ) {
        return new ResponseEntity<>(userService.getFollowersList(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> getFollowersCount(
        @PathVariable @Positive(message = "The user_id must be greater than zero") Long userId
    ) {
        return new ResponseEntity<>(userService.getFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/{userID}/followed/list")
    public ResponseEntity<?> getFollowedSellerList(
        @PathVariable @Positive(message = "The user_id must be greater than zero") Long userID,
        @RequestParam(required = false) @Pattern(regexp = "^(?i)(NAME_ASC|NAME_DESC)$", message = "Order field can only be NAME_ASC or NAME_DESC") String order
    ) {
        return new ResponseEntity<>(userService.getFollowedSellersList(userID, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<MessageResponseDTO> followSeller(
        @PathVariable @Positive(message = "The follower user_id must be greater than zero") Long userId,
        @PathVariable @Positive(message = "The user_id to follow must be greater than zero") Long userIdToFollow
    ) {
        return new ResponseEntity<>(userService.followSeller(userId, userIdToFollow), HttpStatus.OK);
    }
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<MessageResponseDTO> unfollowSeller(
        @PathVariable @Positive(message = "The follower user_id must be greater than zero") Long userId,
        @PathVariable @Positive(message = "The user_id to unfollow must be greater than zero") Long userIdToUnfollow
    ) {
        return new ResponseEntity<>(userService.unfollowSeller(userId, userIdToUnfollow), HttpStatus.OK);
    }
}
