package com.example.be_java_hisp_w23_g3.controller;

import com.example.be_java_hisp_w23_g3.dto.request.post.RequestPostDTO;
import com.example.be_java_hisp_w23_g3.dto.request.post.RequestPromoPostDTO;
import com.example.be_java_hisp_w23_g3.service.post.PostService;
import com.example.be_java_hisp_w23_g3.service.post.PostServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {

    private final PostService postService;

    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<?> setNewPost(@Valid @RequestBody RequestPostDTO postDTO) {
        postService.setNewPost(postDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getFollowedPosts(@PathVariable Long userId, @RequestParam(required = false) String order) {
        return ResponseEntity.ok().body(postService.getFollowedPosts(userId, order));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> setNewPromoPost(@Valid @RequestBody RequestPromoPostDTO promoPostDTO) {
        postService.setNewPromoPost(promoPostDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPromoPostCount(@RequestParam(name = "user_id") Long userId) {
        return ResponseEntity.ok().body(postService.getPromoPostCount(userId));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<?> getPromoPostsList(@RequestParam(name = "user_id") Long userId) {
        return ResponseEntity.ok().body(postService.getPromoPostsList(userId));
    }
}
