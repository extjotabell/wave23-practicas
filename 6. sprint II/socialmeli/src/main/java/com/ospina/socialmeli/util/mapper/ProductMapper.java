package com.ospina.socialmeli.util.mapper;

import com.ospina.socialmeli.dto.request.ProductDTO;
import com.ospina.socialmeli.entity.product.Product;

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
