package com.ejercicio.showroom.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ClothesDTO {
    @JsonIgnore
    private Long code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer quantity;
    @JsonProperty("sale_price")
    private Double salePrice;
}
