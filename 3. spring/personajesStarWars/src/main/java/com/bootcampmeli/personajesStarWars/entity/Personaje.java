package com.bootcampmeli.personajesStarWars.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Personaje {
    String name;
    String height;
    String mass;
    @JsonProperty(value = "hair_color")
    String hairColor;
    @JsonProperty(value = "skin_color")
    String skinColor;
    @JsonProperty(value = "eye_color")
    String eyeColor;
    @JsonProperty(value = "birth_year")
    String birthYear;
    String gender;
    String homeworld;
    String species;
}
