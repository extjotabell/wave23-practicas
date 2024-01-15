package org.bootcamp.productos.repository;

import org.bootcamp.productos.model.entity.Producto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends ElasticsearchRepository<Producto, String> {
}
