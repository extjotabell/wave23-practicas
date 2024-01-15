package com.example.clasenosql.service;

import com.example.clasenosql.entity.Producto;

import java.util.List;

public interface IProductoService {
    Producto save(Producto producto);
    List<Producto> getAll();
    List<Producto> findByType(String type);
    List<Producto> findByPriceByRange(Double price);
    List<Producto> findByNames(String nombre);
}
