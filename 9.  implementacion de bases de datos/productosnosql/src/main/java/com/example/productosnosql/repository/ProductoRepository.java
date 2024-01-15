package com.example.productosnosql.repository;

import com.example.productosnosql.entity.Producto;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends ElasticsearchRepository<Producto, String> {
    @Query("{\"match\": {\"nombre\":{\"query\": \"?0\"}}}")
    public  List<Producto> findByNames(String nombre);
}
