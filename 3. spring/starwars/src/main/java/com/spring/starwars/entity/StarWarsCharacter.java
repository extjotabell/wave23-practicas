package com.spring.starwars.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StarWarsCharacter {
    private String name, hair_color, skin_color, eye_color, birth_year, gender, homeworld, species;
    private int height, mass;
}
