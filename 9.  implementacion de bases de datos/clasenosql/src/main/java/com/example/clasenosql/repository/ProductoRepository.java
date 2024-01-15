package com.example.clasenosql.repository;

import com.example.clasenosql.entity.Producto;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends ElasticsearchRepository<Producto, String> {

    @Query("{\"bool\": {\"filter\": [{\"term\": {\"tipo\": \"?0\"}}]}}")
    List<Producto> findByType(String type);

    @Query("{\"bool\": {\"filter\": [{\"range\": {\"precio_venta\":{\"gte\": \"?0\"}}}]}}")
    List<Producto> findByPriceGreatherThan(Double price);

    @Query("{\"match\": {\"nombre\":{\"query\": \"?0\"}}}")
    List<Producto>findByNames(String name);

}
