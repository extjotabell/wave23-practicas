package com.example.Product.repository;

import com.example.Product.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IProductRepository extends ElasticsearchRepository<Product, String> {
    List<Product> findByType(String type);
    List<Product> findBySellingPriceGreaterThan(String price);

}
