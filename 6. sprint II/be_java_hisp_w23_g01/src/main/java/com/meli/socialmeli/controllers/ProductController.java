package com.meli.socialmeli.controllers;

import com.meli.socialmeli.dtos.request.PostDTO;
import com.meli.socialmeli.dtos.response.PostsFromFollowsDTO;
import com.meli.socialmeli.services.IProductService;
import com.meli.socialmeli.services.impl.ProductServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/products")
public class ProductController {
    private final IProductService iProductService;
    public ProductController(ProductServiceImpl productService){
        this.iProductService = productService;
    }
    /*
        US-0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas
        dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
        US-0009: Ordenamiento por fecha ascendente y descendente.
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostsFromFollowsDTO> getAllPostsFollowsLastTwoWeeks(@PathVariable Integer userId, String order)
    {
        return new ResponseEntity<>(iProductService.getAllPostsFollowsLastTwoWeeks(userId, order), HttpStatus.OK);
    }

    /*
        US-0005: Dar de alta una nueva publicación.
    */
    @PostMapping("/post")
    public ResponseEntity<?> newPost(@Valid @RequestBody PostDTO post){
        return new ResponseEntity<>(iProductService.newPost(post), HttpStatus.OK);
    }
}
