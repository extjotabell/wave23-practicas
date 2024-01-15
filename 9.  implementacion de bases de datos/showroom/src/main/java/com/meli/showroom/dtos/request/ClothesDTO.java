package com.meli.showroom.dtos.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClothesDTO {
    private String code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer amount;
    @JsonAlias("selling_price")
    private Double sellingPrice;
}