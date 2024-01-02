package com.ospina.socialmeli.controller;

import com.ospina.socialmeli.dto.request.PostRequestDTO;
import com.ospina.socialmeli.dto.response.PostResponseDTO;
import com.ospina.socialmeli.service.product.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Validated
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/post")
    public ResponseEntity<PostResponseDTO> postProduct(@Valid @RequestBody PostRequestDTO postRequestDTO) {
        return new ResponseEntity<>(productService.postProduct(postRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> followedPostsList(
        @PathVariable @Positive(message = "El user_id debe ser mayor que cero") Long userId,
        @RequestParam(required = false) @Pattern(regexp = "^(?i)(DATE_ASC|DATE_DESC)$", message = "Order field can only be DATE_ASC or DATE_DESC") String order
    ) {
        return new ResponseEntity<>(productService.followedPostsList(userId, order), HttpStatus.OK);
    }

}
