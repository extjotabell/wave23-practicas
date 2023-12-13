package com.example.ejercicio_blog.controller;

import com.example.ejercicio_blog.dto.BlogDto;
import com.example.ejercicio_blog.service.BlogServiceImpl;
import com.example.ejercicio_blog.service.IBlogService;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class BlogController {

    @Autowired
    IBlogService service;
    @PostMapping("/blog")
    public ResponseEntity<?> saveBlog(@RequestBody BlogDto blogdto){
        BlogDto response = service.saveBlog(blogdto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/blog/id/{id}")
    public ResponseEntity<?> findId(@PathVariable int id){
        return new ResponseEntity<>(service.findId(id), HttpStatus.OK);
    }

    @PostMapping("/blogs")
    public ResponseEntity<?> findId(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
}
