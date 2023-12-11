package com.ejercicio.starwars.entity;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter
@Setter
@ToString
public class Character {
    private String name;
    private Integer height;
    private Integer mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;
}
