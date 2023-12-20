package com.example.be_java_hisp_w23_g3.controller;

import com.example.be_java_hisp_w23_g3.dto.request.PostPromoRequestDTO;
import com.example.be_java_hisp_w23_g3.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w23_g3.dto.response.FollowedPostsResponseDTO;
import com.example.be_java_hisp_w23_g3.dto.response.PostPromoResponseDTO;
import com.example.be_java_hisp_w23_g3.dto.response.PostResponseDTO;
import com.example.be_java_hisp_w23_g3.dto.response.ProductCountResponseDTO;
import com.example.be_java_hisp_w23_g3.service.product.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/post")
    public ResponseEntity<?> postProduct(@RequestBody PostRequestDTO postRequestDTO) {
        PostResponseDTO postResponseDTO = productService.postProduct(postRequestDTO);
        return new ResponseEntity<>(postResponseDTO, HttpStatus.CREATED);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> postPromoProduct(@RequestBody PostPromoRequestDTO postPromoRequestDTO) {
        PostPromoResponseDTO postPromoResponseDTO = productService.postPromoProduct(postPromoRequestDTO);
        return new ResponseEntity<>(postPromoResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<?> getPost(@PathVariable Long postId) {
        PostResponseDTO postResponseDTO = productService.getPost(postId);
        return new ResponseEntity<>(postResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> countPromoPosts(@RequestParam Long user_id) {
        ProductCountResponseDTO productCountDTO = productService.countPromoPosts(user_id);
        return new ResponseEntity<>(productCountDTO, HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> followedPostsList(@PathVariable Long userId, @RequestParam(required = false) String order) {
        FollowedPostsResponseDTO followedPostsListDTO = productService.followedPostsList(userId, order);
        return new ResponseEntity<>(followedPostsListDTO, HttpStatus.OK);
    }
}
