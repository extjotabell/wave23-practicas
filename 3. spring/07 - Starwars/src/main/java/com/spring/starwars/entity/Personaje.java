package com.spring.starwars.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Personaje {
    private String name;
    private int height;
    private int mass;
    @JsonIgnore
    private String hair_color, skin_color, eye_color, birth_year;
    private String gender;
    private String homeworld;
    private String species;
}
