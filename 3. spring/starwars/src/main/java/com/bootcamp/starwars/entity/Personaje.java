package com.bootcamp.starwars.entity;

import lombok.*;

@AllArgsConstructor @Getter @Setter @NoArgsConstructor
public class Personaje {

    private String name, hair_color, skin_color, eye_color, birth_year, gender, homeworld, species;
    private Integer height, mass;

}
