package com.example.ejercicioProductosNoSQL.service;

import com.example.ejercicioProductosNoSQL.dto.MessageDto;
import com.example.ejercicioProductosNoSQL.dto.ProductoDto;

import java.util.List;

public interface IProductoService {

    MessageDto save(ProductoDto productoDto);
    List<ProductoDto> findAll();

}
