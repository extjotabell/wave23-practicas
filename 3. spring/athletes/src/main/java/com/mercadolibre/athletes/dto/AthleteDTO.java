package com.mercadolibre.athletes.dto;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class AthleteDTO {
    private String name;
    private String lastname;
    private String sport;
}