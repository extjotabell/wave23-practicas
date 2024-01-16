package com.example.Product.service;

import com.example.Product.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    ProductDTO save(ProductDTO dto);

    List<ProductDTO> getAllProducts();

}
