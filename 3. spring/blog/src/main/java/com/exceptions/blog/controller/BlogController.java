package com.exceptions.blog.controller;

import com.exceptions.blog.dto.request.RequestBlogDTO;
import com.exceptions.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {
    @Autowired
    IBlogService service;

    @PostMapping("/blog")
    public ResponseEntity<?> saveBlog(@RequestBody RequestBlogDTO requestBlogDTO){
        return new ResponseEntity<>(service.saveBlog(requestBlogDTO), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getBlog(@PathVariable int id){
        return new ResponseEntity<>(service.searchBlog(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> getBlogs(){
        return new ResponseEntity<>(service.listBlogs(), HttpStatus.OK);
    }
}
