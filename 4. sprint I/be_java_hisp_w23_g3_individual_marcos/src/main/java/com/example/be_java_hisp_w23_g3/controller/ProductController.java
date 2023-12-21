package com.example.be_java_hisp_w23_g3.controller;

import com.example.be_java_hisp_w23_g3.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w23_g3.dto.request.PromoPostRequestDTO;
import com.example.be_java_hisp_w23_g3.dto.response.PostResponseDTO;
import com.example.be_java_hisp_w23_g3.dto.response.PromoPostCountDTO;
import com.example.be_java_hisp_w23_g3.dto.response.PromoPostResponseDTO;
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
    public ResponseEntity<?> postProductPromo(@RequestBody PromoPostRequestDTO promoPostRequestDTO) {
        PromoPostResponseDTO promoPostResponseDTO = productService.postProduct(promoPostRequestDTO);
        return new ResponseEntity<>(promoPostResponseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> followedPostsList(@PathVariable Long userId,
                                               @RequestParam(required = false) String order) {
        return ResponseEntity.ok().body(productService.followedPostsList(userId, order));
    }
    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPromoPostCount(@RequestParam("user_id") Long userId) {
        return ResponseEntity.ok().body(productService.getPromoPostCount(userId));
    }
}
