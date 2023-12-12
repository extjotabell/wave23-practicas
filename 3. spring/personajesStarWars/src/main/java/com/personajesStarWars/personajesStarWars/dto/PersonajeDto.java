package com.personajesStarWars.personajesStarWars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PersonajeDto {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String home_world;
    private String species;
}
