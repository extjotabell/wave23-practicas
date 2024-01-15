package com.meli.sqlshowroom.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClothesDTO {
    private Long code;
    private String name;
    private String brand;
    private String color;
    @JsonProperty("size_id")
    private Long sizeId;
    private Integer stock;
    @JsonProperty("selling_price")
    private Double sellingPrice;
}
