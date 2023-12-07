package com.mercadolibre.athletes.entity;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Sport {
    private Integer id;
    private String name;
    private Integer level;

}
