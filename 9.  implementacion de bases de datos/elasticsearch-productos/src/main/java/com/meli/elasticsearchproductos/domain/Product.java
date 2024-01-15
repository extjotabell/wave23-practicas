package com.meli.elasticsearchproductos.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "products")
@TypeAlias("product")
public class Product {
    @Id
    private String id;
    private String name;
    private String type;
    private String price;
    private String costPrice;
    private String stock;
}
