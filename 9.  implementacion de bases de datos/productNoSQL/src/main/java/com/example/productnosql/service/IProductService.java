package com.example.productnosql.service;

import com.example.productnosql.model.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    ProductDTO saveProduct(ProductDTO employeeDTO);
    ProductDTO updateProduct(ProductDTO employeeDTO);
    List<ProductDTO> getAllProducts();
}
