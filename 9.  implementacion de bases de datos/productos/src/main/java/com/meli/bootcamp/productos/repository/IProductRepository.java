package com.meli.bootcamp.productos.repository;

import com.meli.bootcamp.productos.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends ElasticsearchRepository<Product,String> {
}
