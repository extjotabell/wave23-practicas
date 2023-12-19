package com.ospina.socialmeli.controller;

import com.ospina.socialmeli.dto.request.PostRequestDTO;
import com.ospina.socialmeli.dto.request.PostPromoRequestDTO;
import com.ospina.socialmeli.dto.response.PostResponseDTO;
import com.ospina.socialmeli.dto.response.PromoCountResponseDTO;
import com.ospina.socialmeli.service.product.ProductService;
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
    public ResponseEntity<PostResponseDTO> postPromoProduct(@RequestBody PostPromoRequestDTO postPromoRequestDTO) {
        PostResponseDTO postResponseDTO = productService.postPromoProduct(postPromoRequestDTO);
        return new ResponseEntity<>(postResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> followedPostsList(@PathVariable Long userId,
                                               @RequestParam(required = false) String order) {
        return ResponseEntity.ok().body(productService.followedPostsList(userId, order));
    }

    ///products/promo-post/count?user_id={userId}
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoCountResponseDTO> promoPostCount(@RequestParam Long user_id) {
        return ResponseEntity.ok().body(productService.promoPostCount(user_id));
    }
}
