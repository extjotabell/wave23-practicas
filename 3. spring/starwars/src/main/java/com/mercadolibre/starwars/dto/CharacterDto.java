package com.mercadolibre.starwars.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterDto {
    private String name;
    private Integer height;
    private Integer mass;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;
}
