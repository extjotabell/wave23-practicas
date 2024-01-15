package org.ejercicio.products.service;

import org.apache.el.stream.Stream;
import org.ejercicio.products.model.dto.ProductDto;
import org.ejercicio.products.model.entity.Product;
import org.ejercicio.products.repository.IProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository repository;
    private final ModelMapper modelMapper = new ModelMapper();

    public ProductServiceImpl(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = repository.save(modelMapper.map(productDto, Product.class));
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public List<ProductDto> saveProducts(List<ProductDto> productDtos) {
        List<Product> productsToSave = productDtos
                .stream()
                .map(productDto -> modelMapper.map(productDto, Product.class))
                .toList();
        Iterable<Product> productSaved = repository.saveAll(productsToSave);

        return getProductDtos(productSaved);
    }

    private List<ProductDto> getProductDtos(Iterable<Product> productIterable) {
        return StreamSupport
                .stream(productIterable.spliterator(), false)
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
    }

    @Override
    public List<ProductDto> getAllProducts() {
        Iterable<Product> productIterable = repository.findAll();
        return getProductDtos(productIterable);
    }

    @Override
    public List<ProductDto> getFindByAnyMatch(String search) {
        List<Product> products = repository.findByAnyMatch(search);
        return products
                .stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
    }

    @Override
    public void deleteProduct(String productIdr) {
        repository.deleteById(productIdr);
    }


}
