package com.mercadolibre.blog.controller;

import com.mercadolibre.blog.dto.InputBlogDto;

import com.mercadolibre.blog.service.BlogServiceImpl;
import com.mercadolibre.blog.service.IBlogService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {


    IBlogService blogService;
    public BlogController(BlogServiceImpl blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blog")
    public ResponseEntity<?> getBlogs(){
        return new ResponseEntity<>(blogService.searchAllBlogs(), HttpStatus.OK);
    }

    @PostMapping("/blog")
    public ResponseEntity<?> createBlog(@RequestBody InputBlogDto inputBlog) {
    return new ResponseEntity<>(blogService.addBlog(inputBlog), HttpStatus.CREATED);
    }


    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable Long id) {
        return new ResponseEntity<>(blogService.searchIdBlogs(id), HttpStatus.OK);
    }

}
