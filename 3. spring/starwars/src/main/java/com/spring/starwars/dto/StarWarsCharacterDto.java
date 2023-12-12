package com.spring.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StarWarsCharacterDto {
    private String name, gender, homeworld, species;
    private int height, mass;
}
