package com.ejercicio.blog.controller;

import com.ejercicio.blog.dto.request.RequestBlogDto;
import com.ejercicio.blog.service.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    @Autowired
    BlogServiceImpl blog;

    @PostMapping("/blog")
    public ResponseEntity<?> crearBlog(@RequestBody RequestBlogDto nuevoBlog) {
        return new ResponseEntity<>(blog.crearBlog(nuevoBlog), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable int id) {
        return new ResponseEntity<>(blog.getBlogById(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> getBlogs() {
        return new ResponseEntity<>(blog.getBlogs(), HttpStatus.OK);
    }

}
