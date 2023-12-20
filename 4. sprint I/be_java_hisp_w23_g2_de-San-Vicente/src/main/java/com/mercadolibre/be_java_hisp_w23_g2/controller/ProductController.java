package com.mercadolibre.be_java_hisp_w23_g2.controller;


import com.mercadolibre.be_java_hisp_w23_g2.service.IUserService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.mercadolibre.be_java_hisp_w23_g2.dto.PostDTO;
import com.mercadolibre.be_java_hisp_w23_g2.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * Controller class for handling product-related operations.
 */
@RestController
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService;
    private final IUserService userService;

    public ProductController(IProductService productService, IUserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    /**
     * Endpoint for adding a new post.
     *
     * @param postDto The PostDTO containing information about the post to be added.
     * @return ResponseEntity with the result of the addPost operation.
     */
    @PostMapping("/post")
    public ResponseEntity<?> addNormalPost(@RequestBody PostDTO postDto) {
        return new ResponseEntity<>(productService.addNormalPost(postDto), HttpStatus.OK);
    }

    /**
     * Endpoint for adding a new promo post.
     *
     * @param postDto The PostDTO containing information about the post to be added.
     * @return ResponseEntity with the result of the addPost operation.
     */
    @PostMapping("/promo-post")
    public ResponseEntity<?> addPromoPost(@RequestBody PostDTO postDto){
        return new ResponseEntity<>(productService.addPromoPost(postDto), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPromoPostCount(@RequestParam("user_id") int userId){
        return new ResponseEntity<>(productService.getPromoCount(userId), HttpStatus.OK);
    }

    /**
     * Endpoint for retrieving posts by followed users.
     *
     * @param userId The ID of the user whose followed users' posts are to be retrieved.
     * @param order  Optional parameter for specifying the order of the posts.
     * @return ResponseEntity with the result of the getPostsByFollowedUsers operation.
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getPostsByFollowedUsers(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getPostsByFollowedUsers(userId, order), HttpStatus.OK);
    }

    /**
     * Endpoint for retrieving posts by followed users.
     *
     * @param userId     ID of the current user whose followers' posts will be retrieved
     * @param min_date   Minimum date filter
     * @param max_date   Maximum date filter
     * @param min_price  Minimum price filter
     * @param max_price  Maximum price filter
     * @param name       Name filter
     * @param brand      Brand filter
     * @return           ResponseEntity with the userId and the list of posts
     */
    @GetMapping("/{user_id}/filter")
    public ResponseEntity<?> getFilteredProducts(
            @PathVariable("user_id") int userId,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate min_date,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate max_date,
            @RequestParam(required = false) Double min_price,
            @RequestParam(required = false) Double max_price,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String brand
    ) {
        return new ResponseEntity<>(productService.getFilteredPosts(userId, min_date, max_date, min_price, max_price, name, brand), HttpStatus.OK);
    }
}
