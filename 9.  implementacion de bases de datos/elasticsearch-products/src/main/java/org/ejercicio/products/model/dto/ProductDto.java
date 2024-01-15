package org.ejercicio.products.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String id;
    private String name;
    private String type;
    private Double price;
    private Double cost;
    private Integer quantityAvailable;
}
