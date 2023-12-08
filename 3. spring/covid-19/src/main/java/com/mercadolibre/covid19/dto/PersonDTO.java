package com.mercadolibre.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data Transfer Object (DTO) representing information about a person.
 */
@Data
@AllArgsConstructor
public class PersonDTO {
    private String name;
    private String lastname;

}
