package com.mercadolibre.be_java_hisp_w23_g2.controller;


import com.mercadolibre.be_java_hisp_w23_g2.dto.PostPromoDTO;
import com.mercadolibre.be_java_hisp_w23_g2.service.IUserService;
import org.springframework.web.bind.annotation.*;
import com.mercadolibre.be_java_hisp_w23_g2.dto.PostDTO;
import com.mercadolibre.be_java_hisp_w23_g2.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> addPost(@RequestBody PostDTO postDto) {
        return new ResponseEntity<>(productService.addPost(postDto), HttpStatus.OK);
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
     * Endpoint for adding a new post.
     *
     * @param postDto The PostDTO containing information about the post to be added.
     * @return ResponseEntity with the result of the addPost operation.
     */
    @PostMapping("/promo-post")
    public ResponseEntity<?> addPostWithPromo(@RequestBody PostPromoDTO postDto) {
        return new ResponseEntity<>(productService.addPostPromo(postDto), HttpStatus.OK);
    }

    /**
     * Retrieves the count of products in promotion for a specified user.
     *
     * @param user_id The ID of the user.
     * @return ResponseEntity with the result of the getPromoProductCountByUser operation.
     */
    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPromoProductCountByUser(@RequestParam int user_id) {
        return new ResponseEntity<>(productService.getPromoProductCountByUser(user_id), HttpStatus.OK);
    }

    /**
     * Endpoint for retrieving posts based on a keyword in the category.
     *
     * @param keyword The keyword to search for in post category's.
     * @return ResponseEntity with the result of the searchPostsByKeyword operation.
     */
    @GetMapping("/search-by-keyword/{keyword}")
    public ResponseEntity<?> searchPostsByKeyword(@PathVariable String keyword) {
        return new ResponseEntity<>(productService.searchPostsByCategory(keyword), HttpStatus.OK);
    }
}
