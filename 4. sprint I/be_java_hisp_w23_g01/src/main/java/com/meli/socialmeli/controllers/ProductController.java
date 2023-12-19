package com.meli.socialmeli.controllers;

import com.meli.socialmeli.dtos.request.PostDTO;
import com.meli.socialmeli.dtos.request.PromoPostDTO;
import com.meli.socialmeli.dtos.response.PostsFromFollowsDTO;
import com.meli.socialmeli.exceptions.custom.DataSourceException;
import com.meli.socialmeli.services.IProductService;
import com.meli.socialmeli.services.impl.ProductServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;


@RestController
@RequestMapping("/products")
public class ProductController {
    private final IProductService iProductService;
    public ProductController(ProductServiceImpl productService){
        this.iProductService = productService;
    }
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostsFromFollowsDTO> getAllPostsFollowsLastTwoWeeks(@PathVariable Integer userId, @RequestParam(defaultValue = "date_asc") String order)
    {
        return new ResponseEntity<>(iProductService.getAllPostsFollowsLastTwoWeeks(userId, order), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<?> newPost(@RequestBody PostDTO post){
        return new ResponseEntity<>(iProductService.newPost(post), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> createPromoPost(@RequestBody PromoPostDTO promoPostDTO){
        return new ResponseEntity<>(iProductService.createPromoPost(promoPostDTO), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getCountPromoPosts(@RequestParam Optional<Integer> user_id){
        if(user_id.isEmpty()){ throw new DataSourceException("user_id is needed"); }
        return new ResponseEntity<>(iProductService.getCountPromoPosts(user_id.get()), HttpStatus.OK);
    }
}
