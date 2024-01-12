package com.example.productonosql.service;

import com.example.productonosql.model.Product;
import com.example.productonosql.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private ProductRepository repository;

  public ProductService(ProductRepository repository) {
    this.repository = repository;
  }

  public Product save(Product product) {
    repository.save(product);
    return product;
  }

  public Product update(String id, Product product){
    product.setId(id);
    return save(product);
  }

  public Iterable<Product> findAll() {
    return repository.findAll();
  }
}
