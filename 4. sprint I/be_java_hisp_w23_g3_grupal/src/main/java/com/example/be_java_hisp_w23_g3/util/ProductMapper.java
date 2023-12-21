package com.example.be_java_hisp_w23_g3.util;

import com.example.be_java_hisp_w23_g3.dto.ProductDTO;
import com.example.be_java_hisp_w23_g3.entity.Product;

public class ProductMapper {

    public static ProductDTO toProductDTO(Product product){
        return new ProductDTO(
            product.getId(),
            product.getName(),
            product.getType(),
            product.getBrand(),
            product.getColor(),
            product.getNotes()
        );
    }

    public static Product toProduct(ProductDTO productDTO){
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
