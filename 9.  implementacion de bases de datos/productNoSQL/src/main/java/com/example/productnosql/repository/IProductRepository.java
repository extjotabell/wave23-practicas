package com.example.productnosql.repository;

import com.example.productnosql.model.entity.Product;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends ElasticsearchRepository<Product, String> {

}
