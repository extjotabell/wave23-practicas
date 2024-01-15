package com.meli.elasticsearchproductos.service;

import com.meli.elasticsearchproductos.domain.dto.ProductDTO;

public interface IProductService {
    ProductDTO save(ProductDTO product);
}
