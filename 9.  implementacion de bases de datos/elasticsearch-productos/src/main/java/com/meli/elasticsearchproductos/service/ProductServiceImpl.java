package com.meli.elasticsearchproductos.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.elasticsearchproductos.domain.Product;
import com.meli.elasticsearchproductos.domain.dto.ProductDTO;
import com.meli.elasticsearchproductos.repository.IProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository repository;
    private final ObjectMapper mapper = new ObjectMapper();
    public ProductServiceImpl(IProductRepository repository) { this.repository = repository; }
    @Override
    public ProductDTO save(ProductDTO product) {
        repository.save(mapper.convertValue(product, Product.class));
        return product;
    }
}
