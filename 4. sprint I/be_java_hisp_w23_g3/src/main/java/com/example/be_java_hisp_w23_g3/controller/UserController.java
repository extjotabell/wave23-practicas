package com.example.be_java_hisp_w23_g3.controller;

import com.example.be_java_hisp_w23_g3.service.user.UserService;

import com.example.be_java_hisp_w23_g3.dto.response.FollowersListDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersListDTO> getFollowersList(@PathVariable("userId") Long userId,
                                                             @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getFollowersList(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getFollowersCount(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getFollowersCount(userId));
    }

    @GetMapping("/{userID}/followed/list")
    public ResponseEntity<?> getFollowedSellerList(@PathVariable Long userID,
                                                   @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getFollowedSellersList(userID, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followSeller(@PathVariable Long userId, @PathVariable Long userIdToFollow){
        return ResponseEntity.ok().body(userService.followSeller(userId, userIdToFollow));
    }
     @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unFollowSeller(@PathVariable Long userId, @PathVariable Long userIdToUnfollow){
        return ResponseEntity.ok().body(userService.unFollowSeller(userId, userIdToUnfollow));
    }
}
