package com.example.blog.controller;


import com.example.blog.entity.EntryBlog;
import com.example.blog.service.IBlogService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    private final IBlogService blogService;

    public BlogController(IBlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getEntryBlogById(@PathVariable Long id) {
        return ResponseEntity.ok(blogService.getEntryBlogById(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> getEntryBlogById() {
        return ResponseEntity.ok(blogService.getAllEntryBlog());
    }


    @PostMapping("/blog")
    public ResponseEntity<?> getEntryBlogById(@DateTimeFormat(pattern = "dd-MM-yyyy") @RequestBody EntryBlog blog) {
        return ResponseEntity.ok(blogService.addEntryBlog(blog));
    }
}
