package com.mercadolibre.athletes.entity;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Athlete {
    private String name;
    private String lastname;
    private Integer age;
    private Sport sport;

}
