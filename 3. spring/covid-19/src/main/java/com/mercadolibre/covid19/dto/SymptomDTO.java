package com.mercadolibre.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data Transfer Object (DTO) representing information about a symptom.
 */
@Data
@AllArgsConstructor
public class SymptomDTO {
    private String name;
    private Integer severityLevel;
}
