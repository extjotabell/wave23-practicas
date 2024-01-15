package com.meli.Productos.repository;

import com.meli.Productos.entity.Producto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductoRepository extends ElasticsearchRepository<Producto, String> {
}