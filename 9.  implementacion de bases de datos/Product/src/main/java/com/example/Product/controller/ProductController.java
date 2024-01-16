package com.example.Product.controller;

import com.example.Product.dto.ProductDTO;
import com.example.Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService service;

    @PostMapping("/new")
    public ResponseEntity<?> addProduct(@RequestBody ProductDTO product) {
        return new ResponseEntity<>(service.save(product), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

}
