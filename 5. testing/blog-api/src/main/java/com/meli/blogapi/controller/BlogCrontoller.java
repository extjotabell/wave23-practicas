package com.meli.blogapi.controller;

import com.meli.blogapi.dto.request.EntryBlogDTO;
import com.meli.blogapi.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blogs")
public class BlogCrontoller {

    private final IBlogService blogService;

    public BlogCrontoller(IBlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public ResponseEntity<List<EntryBlogDTO>> getAll(){
        return new ResponseEntity<>(blogService.getAll(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntryBlogDTO> getById(@PathVariable long id){
        return new ResponseEntity<>(blogService.getById(id), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<EntryBlogDTO> saveNewBlog(@RequestBody EntryBlogDTO entryBlogDTO){
        return new ResponseEntity<>(blogService.save(entryBlogDTO), HttpStatus.CREATED);
    }
}
