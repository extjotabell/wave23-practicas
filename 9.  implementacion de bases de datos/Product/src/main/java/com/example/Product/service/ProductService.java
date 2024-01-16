package com.example.Product.service;

import com.example.Product.dto.ProductDTO;
import com.example.Product.entity.Product;
import com.example.Product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository repository;

    @Override
    public ProductDTO save(ProductDTO dto) {
        Product product = mapToEntity(dto);
        repository.save(product);
        return mapToDTO(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> productList = StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .toList();

        return productList.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private ProductDTO mapToDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getType(),
                product.getSellingPrice(),
                product.getCostPrice(),
                product.getQuantityAvailable()
        );
    }

    private Product mapToEntity(ProductDTO dto) {
        return new Product(
                dto.getId(),
                dto.getName(),
                dto.getType(),
                dto.getSellingPrice(),
                dto.getCostPrice(),
                dto.getQuantityAvailable()
        );
    }
}
