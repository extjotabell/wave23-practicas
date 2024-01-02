package com.mercadolibre.be_java_hisp_w23_g2.controller;


import com.mercadolibre.be_java_hisp_w23_g2.dto.requests.PostDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.MessageDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.PostsFollowedDTO;
import com.mercadolibre.be_java_hisp_w23_g2.service.IProductService;
import com.mercadolibre.be_java_hisp_w23_g2.service.IUserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
  public ResponseEntity<MessageDTO> addPost(@RequestBody @Valid PostDTO postDto) {
    return ResponseEntity.ok(productService.addPost(postDto));
  }

  /**
   * Endpoint for retrieving posts by followed users.
   *
   * @param userId The ID of the user whose followed users' posts are to be retrieved.
   * @param order  Optional parameter for specifying the order of the posts.
   * @return ResponseEntity with the result of the getPostsByFollowedUsers operation.
   */
  @GetMapping("/followed/{userId}/list")
  public ResponseEntity<PostsFollowedDTO> getPostsByFollowedUsers(
      @PathVariable @Positive(message = "El id debe ser mayor a cero") Integer userId,
      @RequestParam(required = false) String order) {
    return ResponseEntity.ok(userService.getPostsByFollowedUsers(userId, order));
  }
}
