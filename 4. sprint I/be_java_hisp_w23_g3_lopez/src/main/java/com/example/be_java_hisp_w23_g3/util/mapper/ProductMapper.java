package com.example.be_java_hisp_w23_g3.util.mapper;

import com.example.be_java_hisp_w23_g3.dto.response.ProductResponseDTO;
import com.example.be_java_hisp_w23_g3.entity.product.Product;

public class ProductMapper {

    public static ProductResponseDTO toProductDTO(Product product){
        return new ProductResponseDTO(
            product.getId(),
            product.getName(),
            product.getType(),
            product.getBrand(),
            product.getColor(),
            product.getNotes()
        );
    }

    public static Product toProduct(ProductResponseDTO productDTO){
        return Product.build(
            productDTO.getProductId(),
            productDTO.getProductName(),
            productDTO.getType(),
            productDTO.getBrand(),
            productDTO.getColor(),
            productDTO.getNotes()
        );
    }
}
