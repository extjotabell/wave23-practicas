package com.example.productonosql.controller;

import com.example.productonosql.model.Product;
import com.example.productonosql.service.ProductService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

  private ProductService service;

  public ProductController(ProductService service) {
    this.service = service;
  }

  @PostMapping
  public Product addProduct(@RequestBody Product product) {
    return service.save(product);
  }

  @PutMapping("/{id}")
  public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
    return service.update(id, product);
  }

  @GetMapping
  public List<Product> getAllProducts() {
    return StreamSupport.stream(service.findAll().spliterator(), false).collect(Collectors.toList());
  }
}
