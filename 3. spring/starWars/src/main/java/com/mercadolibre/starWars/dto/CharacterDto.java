package com.mercadolibre.starWars.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mercadolibre.starWars.entitiy.Character;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties({ "hair_color", "skin_color", "eye_color", "birth_year" })
public class CharacterDto {
    private String name;
    private String height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;

    public static Character dtoToCharacter(CharacterDto characterJson){

        return new Character(
                characterJson.getName(),
                characterJson.getHeight(),
                characterJson.getMass(),
                characterJson.getGender(),
                characterJson.getHomeworld(),
                characterJson.getSpecies()
        );
    }

}
