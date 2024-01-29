package com.starwars.startwars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonajeDTO {
    private String name;
    private String gender;
    private String homeworld;
    private String species;
    private Integer height;
    private Integer mass;
}