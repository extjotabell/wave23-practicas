package com.meli.elasticsearchproductos.controller;

import com.meli.elasticsearchproductos.domain.dto.ProductDTO;
import com.meli.elasticsearchproductos.service.IProductService;
import com.meli.elasticsearchproductos.service.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductService service;

    public ProductController(ProductServiceImpl service) { this.service = service; }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProductDTO product) {
        return new ResponseEntity<>(service.save(product), HttpStatus.OK);
    }
}
