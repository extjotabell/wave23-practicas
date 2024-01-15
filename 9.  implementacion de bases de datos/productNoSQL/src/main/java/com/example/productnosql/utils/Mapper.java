package com.example.productnosql.utils;

import com.example.productnosql.model.dto.ProductDTO;
import com.example.productnosql.model.entity.Product;

public class Mapper {

    private Mapper() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static ProductDTO mapToProductDTO(Product employee) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(employee.getId());
        productDTO.setNameProduct(employee.getNameProduct());
        productDTO.setTypeProduct(employee.getTypeProduct());
        productDTO.setPriceCostProduct(employee.getPriceCostProduct());
        productDTO.setPriceSaleProduct(employee.getPriceSaleProduct());
        productDTO.setStockProduct(employee.getStockProduct());
        return productDTO;
    }

    public static Product mapToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setNameProduct(productDTO.getNameProduct());
        product.setTypeProduct(productDTO.getTypeProduct());
        product.setPriceCostProduct(productDTO.getPriceCostProduct());
        product.setPriceSaleProduct(productDTO.getPriceSaleProduct());
        product.setStockProduct(productDTO.getStockProduct());
        return product;
    }
}
