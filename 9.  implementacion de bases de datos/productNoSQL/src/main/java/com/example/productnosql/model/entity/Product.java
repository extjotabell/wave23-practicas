package com.example.productnosql.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "products")
@TypeAlias("products")
public class Product {
    @Id
    private String id;
    private String nameProduct;
    private String typeProduct;
    private String priceSaleProduct;
    private String priceCostProduct;
    private String stockProduct;
}
