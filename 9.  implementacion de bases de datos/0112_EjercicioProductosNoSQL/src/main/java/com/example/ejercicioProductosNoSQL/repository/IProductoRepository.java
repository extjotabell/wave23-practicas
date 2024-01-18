package com.example.ejercicioProductosNoSQL.repository;

import com.example.ejercicioProductosNoSQL.model.Producto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends ElasticsearchRepository<Producto, Integer> {
}
