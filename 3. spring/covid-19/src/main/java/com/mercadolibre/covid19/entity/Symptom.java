package com.mercadolibre.covid19.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Entity class representing a symptom associated with COVID-19.
 */
@Data
@AllArgsConstructor
public class Symptom {
    private Integer code;
    private String name;
    private Integer severityLevel;
}
