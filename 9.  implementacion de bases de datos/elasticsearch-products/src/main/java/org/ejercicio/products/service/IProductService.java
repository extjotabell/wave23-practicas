package org.ejercicio.products.service;

import org.ejercicio.products.model.dto.ProductDto;

import java.util.List;

public interface IProductService {
    ProductDto saveProduct(ProductDto productDto);

    List<ProductDto> saveProducts(List<ProductDto> productDtos);

    List<ProductDto> getAllProducts();

    List<ProductDto> getFindByAnyMatch(String search);

    void deleteProduct(String productIdr);
}
