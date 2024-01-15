package com.meli.bootcamp.productos.service;

import com.meli.bootcamp.productos.dto.ProductDto;
import com.meli.bootcamp.productos.entity.Product;

import java.util.List;

public interface IProductService {
    ProductDto save(ProductDto productDto);

    List<ProductDto> findAll();

    ProductDto update(ProductDto productDto);
}
