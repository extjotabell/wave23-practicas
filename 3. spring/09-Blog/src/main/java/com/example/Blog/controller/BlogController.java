package com.example.Blog.controller;

import com.meli.blog.dto.BlogDTO;
import com.meli.blog.service.BlogService;
import com.meli.blog.service.IBlogService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
public class BlogController {
    IBlogService service;
    @Autowired
    public BlogController(BlogService blogService){
        this.service = blogService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody BlogDTO blogDTO){
        BlogDTO response = service.saveBlog(blogDTO);
        return new ResponseEntity<>(response.getId(), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BlogDTO> findById(@PathVariable long id){
        BlogDTO response = service.findById(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTO>> getAll(){
        List<BlogDTO> response = service.getAll();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
