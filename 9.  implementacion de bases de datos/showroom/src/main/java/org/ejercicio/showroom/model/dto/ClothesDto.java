package org.ejercicio.showroom.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClothesDto {
    private String id;
    private String code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private Integer size;
    private Integer count;
    private Double price;
}
