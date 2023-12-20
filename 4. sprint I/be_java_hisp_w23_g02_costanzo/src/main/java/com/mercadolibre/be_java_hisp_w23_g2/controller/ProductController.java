package com.mercadolibre.be_java_hisp_w23_g2.controller;


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
     * Endpoint for retrieving a new post in promotion.
     *
     * @param postDto The PostDTO containing information about the post to be added.
     * @return ResponseEntity with the result of the addPromoPost operation.
     */
    @PostMapping("/promo-post")
    public ResponseEntity<?> addPromoPost(@RequestBody PostDTO postDto) {
        return new ResponseEntity<>(productService.addPromoPost(postDto), HttpStatus.OK);
    }

    /**
     * Endpoint for retrieving the quantity of products on promotion for a given vendor.
     *
     * @param user_id The ID to use.
     * @return ResponseEntity with the result of the getProductsPromCount operation.
     */
    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getProductsPromCount(@RequestParam int user_id) {
        return new ResponseEntity<>(productService.getProductsPromCount(user_id), HttpStatus.OK);
    }
}
