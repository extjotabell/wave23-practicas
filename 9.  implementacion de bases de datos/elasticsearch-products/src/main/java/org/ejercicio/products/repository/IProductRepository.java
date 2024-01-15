package org.ejercicio.products.repository;

import org.ejercicio.products.model.entity.Product;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends ElasticsearchRepository<Product, String> {
    @Query("{\"query_string\": {\"query\": \"?0\"}}")
    List<Product> findByAnyMatch(String search);
}
