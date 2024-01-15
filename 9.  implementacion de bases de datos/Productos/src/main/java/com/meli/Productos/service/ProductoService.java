package com.meli.Productos.service;

import com.meli.Productos.dto.ProductoDto;

import java.util.List;

public interface ProductoService {

    List<ProductoDto> findAll();
    ProductoDto findById(String id);
    ProductoDto save(ProductoDto empleado);
    void deleteById(String id);

}
