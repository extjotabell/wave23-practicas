package com.bootcamp.starwars.dto;

import com.bootcamp.starwars.entity.Personaje;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @Data @NoArgsConstructor
public class PersonajeDTO {

    private String name, gender, homeworld, species;
    private Integer height, mass;

    public PersonajeDTO(Personaje personaje) {
    }
}
