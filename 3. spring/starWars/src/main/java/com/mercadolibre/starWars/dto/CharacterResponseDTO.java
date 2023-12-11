package com.mercadolibre.starWars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data Transfer Object (DTO) representing the response for a Star Wars character.
 */
@Data
@AllArgsConstructor
public class CharacterResponseDTO {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;
}
