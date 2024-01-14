package com.example.clasenosql.repository;

import com.example.clasenosql.entity.Producto;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductosRepository extends ElasticsearchRepository<Producto, String> {

}
