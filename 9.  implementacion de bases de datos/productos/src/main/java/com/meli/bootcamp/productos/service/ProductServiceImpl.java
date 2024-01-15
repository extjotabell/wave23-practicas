package com.meli.bootcamp.productos.service;

import com.meli.bootcamp.productos.dto.ProductDto;
import com.meli.bootcamp.productos.entity.Product;
import com.meli.bootcamp.productos.repository.IProductRepository;
import com.meli.bootcamp.productos.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements IProductService{
    private IProductRepository productRepository;

    public ProductServiceImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        return Mapper.mapToProductDto(productRepository.save(Mapper.mapToProduct(productDto)));
    }

    @Override
    public List<ProductDto> findAll() {
        Iterable<Product> productDtoIterable = productRepository.findAll();
        List<Product> products = StreamSupport
                .stream(productDtoIterable.spliterator(),false)
                .collect(Collectors.toList());
        return products
                .stream()
                .map(product -> Mapper.mapToProductDto(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        Product product = productRepository.findById(productDto.getId()).orElse(null);
        product.setTipo(productDto.getTipo());
        product.setStock(productDto.getStock());
        product.setNombre(productDto.getNombre());
        product.setPrecioVenta(productDto.getPrecioVenta());
        product.setPrecioCosto(productDto.getPrecioCosto());
        return Mapper.mapToProductDto(productRepository.save(product));
    }
}
