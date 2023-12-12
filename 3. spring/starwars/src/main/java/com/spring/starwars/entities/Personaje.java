package com.spring.starwars.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.spring.starwars.utils.NullableIntegerDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Personaje {
    private String name;
    @JsonDeserialize(using = NullableIntegerDeserializer.class)
    private Integer height;
    @JsonDeserialize(using = NullableIntegerDeserializer.class)
    private Integer mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;

}
