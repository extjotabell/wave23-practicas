package org.ejercicio.products.model.entity;

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
    private Double price;
    private Double cost;
    private Integer quantityAvailable;
}
