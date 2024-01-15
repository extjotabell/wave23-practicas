package com.meli.bootcamp.productos.controller;

import com.meli.bootcamp.productos.dto.ProductDto;
import com.meli.bootcamp.productos.entity.Product;
import com.meli.bootcamp.productos.service.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public ResponseEntity<List<ProductDto>> findAll(){
        return new ResponseEntity<>(productService.findAll(),HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.save(productDto), HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.update(productDto),HttpStatus.OK);
    }
}
