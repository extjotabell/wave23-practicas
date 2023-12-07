package com.mercadolibre.athletes.dto;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class SportDTO {
    private String name;
    private Integer level;
}