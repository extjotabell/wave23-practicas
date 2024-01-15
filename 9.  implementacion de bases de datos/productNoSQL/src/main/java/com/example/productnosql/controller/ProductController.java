package com.example.productnosql.controller;

import com.example.productnosql.model.dto.ProductDTO;
import com.example.productnosql.service.IProductService;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(productService.saveProduct(productDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(productService.updateProduct(productDTO));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
