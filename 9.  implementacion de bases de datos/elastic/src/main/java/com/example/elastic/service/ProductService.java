package com.example.elastic.service;

import com.example.elastic.entity.Producto;

import java.util.List;

public interface ProductService {
    String save(Producto producto);

    List<Producto> getAll();

    Producto update(String id, Producto producto);
}
