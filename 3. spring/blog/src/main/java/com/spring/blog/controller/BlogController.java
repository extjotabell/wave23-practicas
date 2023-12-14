package com.spring.blog.controller;

import com.spring.blog.dto.BlogRequestDto;
import com.spring.blog.service.interfaces.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    @Autowired
    private IBlogService _service;

    @PostMapping("/blog")
    public ResponseEntity<?> saveBlog(@RequestBody BlogRequestDto blog) {
        return new ResponseEntity<>(_service.saveBlog(blog), HttpStatus.CREATED);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> allBlogs() {
        return new ResponseEntity<>(_service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable Integer id) {
        return new ResponseEntity<>(_service.findBlogById(id), HttpStatus.OK);
    }
}
