package com.example.productnosql.service.impl;

import com.example.productnosql.exceptions.IdNoExistsException;
import com.example.productnosql.model.dto.ProductDTO;
import com.example.productnosql.model.entity.Product;
import com.example.productnosql.repository.IProductRepository;
import com.example.productnosql.service.IProductService;
import com.example.productnosql.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;

    public ProductServiceImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = Mapper.mapToProduct(productDTO);
        product = productRepository.save(product);
        return Mapper.mapToProductDTO(product);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        if (!productRepository.existsById(productDTO.getId())) {
            throw new IdNoExistsException();
        }
        Product product = Mapper.mapToProduct(productDTO);
        product = productRepository.save(product);
        return Mapper.mapToProductDTO(product);
    }
    @Override
    public List<ProductDTO> getAllProducts(){
        Iterable<Product> productIterable = productRepository.findAll();
        return StreamSupport.stream(productIterable.spliterator(), false).map(Mapper::mapToProductDTO).toList();
    }
}
