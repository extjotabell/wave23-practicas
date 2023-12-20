package com.example.be_java_hisp_w23_g3.controller;

import com.example.be_java_hisp_w23_g3.dto.request.UserRequestDTO;
import com.example.be_java_hisp_w23_g3.dto.response.*;
import com.example.be_java_hisp_w23_g3.service.user.UserService;

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

    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = userService.createUser(userRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getFollowersList(@PathVariable("userId") Long userId, @RequestParam(required = false) String order) {
        FollowersListResponseDTO followersListDTO = userService.getFollowersList(userId, order);
        return new ResponseEntity<>(followersListDTO, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getFollowersCount(@PathVariable Long userId) {
        FollowersCountResponseDTO followersCountDTO = userService.getFollowersCount(userId);
        return new ResponseEntity<>(followersCountDTO, HttpStatus.OK);
    }

    @GetMapping("/{userID}/followed/list")
    public ResponseEntity<?> getFollowedSellerList(@PathVariable Long userID, @RequestParam(required = false) String order) {
        FollowedListResponseDTO followersListDTO = userService.getFollowedSellersList(userID, order);
        return new ResponseEntity<>(followersListDTO, HttpStatus.OK);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followSeller(@PathVariable Long userId, @PathVariable Long userIdToFollow){
        MessageResponseDTO messageResponseDTO = userService.followSeller(userId, userIdToFollow);
        return new ResponseEntity<>(messageResponseDTO, HttpStatus.OK);
    }
     @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unFollowSeller(@PathVariable Long userId, @PathVariable Long userIdToUnfollow){
        MessageResponseDTO messageResponseDTO = userService.unFollowSeller(userId, userIdToUnfollow);
        return new ResponseEntity<>(messageResponseDTO, HttpStatus.OK);
    }
}
