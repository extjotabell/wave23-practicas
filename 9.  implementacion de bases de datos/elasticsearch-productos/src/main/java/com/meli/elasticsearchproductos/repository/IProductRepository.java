package com.meli.elasticsearchproductos.repository;

import com.meli.elasticsearchproductos.domain.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends ElasticsearchRepository<Product, String> {
}
