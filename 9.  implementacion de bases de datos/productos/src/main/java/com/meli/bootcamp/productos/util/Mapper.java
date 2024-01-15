package com.meli.bootcamp.productos.util;

import com.meli.bootcamp.productos.dto.ProductDto;
import com.meli.bootcamp.productos.entity.Product;

public class Mapper {
    public static ProductDto mapToProductDto(Product product){
        if(product == null) return null;
        return new ProductDto(product.getId(), product.getNombre(), product.getTipo(), product.getPrecioVenta(), product.getPrecioCosto(), product.getStock());
    }
    public static Product mapToProduct(ProductDto productDto){
        if(productDto == null) return null;
        return new Product(productDto.getId(), productDto.getNombre(), productDto.getTipo(), productDto.getPrecioVenta(), productDto.getPrecioCosto(), productDto.getStock());
    }
}
