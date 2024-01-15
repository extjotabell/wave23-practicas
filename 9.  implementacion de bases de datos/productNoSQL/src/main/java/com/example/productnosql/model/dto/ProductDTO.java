package com.example.productnosql.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ProductDTO {
    private String id;
    private String nameProduct;
    private String typeProduct;
    private String priceSaleProduct;
    private String priceCostProduct;
    private String stockProduct;
}
