package com.mercadolibre.be_java_hisp_w23_g2.controller;


import com.mercadolibre.be_java_hisp_w23_g2.dto.PostPromoDTO;
import com.mercadolibre.be_java_hisp_w23_g2.service.IPostService;
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
    private final IPostService postService;

    public ProductController(IProductService productService, IUserService userService, IPostService postService) {
        this.productService = productService;
        this.userService = userService;
        this.postService = postService;
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

    @PostMapping("/promo-post")
    public ResponseEntity<?> addPostPromo(@RequestBody PostPromoDTO postPromoDTO) {
        return new ResponseEntity<>(postService.addPostPromo(postPromoDTO), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count/user_id={userId}")
    public ResponseEntity<?> getPromoCountSeller(@PathVariable int userId) {
        return ResponseEntity.ok(postService.getPromoCountSeller(userId));
    }

    @GetMapping("/promo-post/list/category={category}")
    public ResponseEntity<?> getPostsPromoByProduct(@PathVariable String category) {
        return new ResponseEntity<>(postService.getPostsPromoByCategory(category), HttpStatus.OK);
    }
}
