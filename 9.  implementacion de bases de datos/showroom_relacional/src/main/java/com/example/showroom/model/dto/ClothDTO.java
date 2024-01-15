package com.example.showroom.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClothDTO {
    @JsonIgnore
    private Integer code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private Integer size;
    private Integer amount;
    private Double precioVenta;
}