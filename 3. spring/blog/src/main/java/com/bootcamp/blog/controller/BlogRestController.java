package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.service.BlogServiceImplementation;
import com.bootcamp.blog.service.BlogServiceImplementation;
import com.bootcamp.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api")
public class BlogRestController {

    @Autowired
    IBlogService service;

    @PostMapping("/blog")
    public ResponseEntity<?> saveBlog(@RequestBody BlogDTO blogdto){
        BlogDTO response = service.saveBlog(blogdto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return new ResponseEntity<>(service.findId(id), HttpStatus.OK);
    }

    @GetMapping("/blog/findAll")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

}
