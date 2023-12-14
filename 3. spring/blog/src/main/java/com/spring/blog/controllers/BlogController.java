package com.spring.blog.controllers;

import com.spring.blog.dtos.BlogDto;
import com.spring.blog.services.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @PostMapping("/")
    public ResponseEntity<?> createBlog(@RequestBody BlogDto blogDto){
        BlogDto response = blogService.createBlog(blogDto);
        return new ResponseEntity<>("Blog created with id: "+blogDto.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findBlogById(@PathVariable Long id){
        BlogDto response = blogService.findBlogById(id);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllBlogs(){
        List<BlogDto> response = blogService.getAllBlogs();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

