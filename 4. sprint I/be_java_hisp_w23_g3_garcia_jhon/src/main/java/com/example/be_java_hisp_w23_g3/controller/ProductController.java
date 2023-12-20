package com.example.be_java_hisp_w23_g3.controller;

import com.example.be_java_hisp_w23_g3.dto.request.PostPromoRequestDTO;
import com.example.be_java_hisp_w23_g3.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w23_g3.dto.response.PostResponseDTO;
import com.example.be_java_hisp_w23_g3.service.product.ProductService;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addCustomFormatter(new DateFormatter("dd-MM-yyyy"));
    }

    @PostMapping("/post")
    public ResponseEntity<PostResponseDTO> postProduct(@RequestBody PostRequestDTO postRequestDTO) {
        PostResponseDTO postResponseDTO = productService.postProduct(postRequestDTO);
        return new ResponseEntity<>(postResponseDTO, HttpStatus.CREATED);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PostResponseDTO> postProductPromo(@RequestBody PostPromoRequestDTO postRequestDTO){
        return new ResponseEntity<>(productService.postProduct(postRequestDTO),HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> followedPostsList(@PathVariable Long userId,
                                               @RequestParam(required = false) String order) {
        return ResponseEntity.ok().body(productService.followedPostsList(userId, order));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getCountPromoPosts(@RequestParam("user_id") Long userID){
        return new ResponseEntity<>(productService.getPostsPromoCount(userID), HttpStatus.OK);
    }

    @GetMapping("/promo-post/user/{userID}/list")
    public ResponseEntity<?> getPostsProductPromo(@PathVariable Long userID){
        return new ResponseEntity<>(productService.getPostsPromoBySeller(userID), HttpStatus.OK);
    }

    @GetMapping("/post/user/{userID}/calculate-price")
    public ResponseEntity<?> getPricePostsProducts(@PathVariable Long userID){
        return new ResponseEntity<>(productService.getPricePostsProducts(userID), HttpStatus.OK);
    }
}
