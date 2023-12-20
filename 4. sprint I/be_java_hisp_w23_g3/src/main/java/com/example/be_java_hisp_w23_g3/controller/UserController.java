package com.example.be_java_hisp_w23_g3.controller;

import com.example.be_java_hisp_w23_g3.service.user.UserService;
import com.example.be_java_hisp_w23_g3.service.user.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> setNewFollower(@PathVariable Long userId, @PathVariable Long userIdToFollow) {
        userService.setNewFollower(userId, userIdToFollow);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getFollowersCount(@PathVariable Long userId) {
        return ResponseEntity.ok().body(userService.getFollowersCount(userId));
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getFollowers(@PathVariable Long userId, @RequestParam(required = false) String order) {
        return ResponseEntity.ok().body(userService.getFollowers(userId, order));
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> getFollowing(@PathVariable Long userId, @RequestParam(required = false) String order) {
        return ResponseEntity.ok().body(userService.getFollowing(userId, order));
    }

    @GetMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable Long userId, @PathVariable Long userIdToUnfollow) {
        userService.unfollow(userId, userIdToUnfollow);
        return ResponseEntity.ok().build();
    }
}
