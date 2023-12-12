package com.personajesStarWars.personajesStarWars.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@ToString

public class Personaje {
    private String name;
    private Integer height;
    private Integer mass;
    private String hair_Color;
    private String skin_Color;
    private String eye_Color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;
}
