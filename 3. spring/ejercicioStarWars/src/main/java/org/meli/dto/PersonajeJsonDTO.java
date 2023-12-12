package org.meli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.meli.model.Personaje;

@Getter @AllArgsConstructor @NoArgsConstructor
public class PersonajeJsonDTO {
    private String name;
    private int height;
    private int mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;

    public static Personaje dtoToPersonaje(PersonajeJsonDTO personajeJson){

        return new Personaje(
                personajeJson.getName(),
                personajeJson.getHeight(),
                personajeJson.getMass(),
                personajeJson.getHair_color(),
                personajeJson.getSkin_color(),
                personajeJson.getEye_color(),
                personajeJson.getBirth_year(),
                personajeJson.getGender(),
                personajeJson.getHomeworld(),
                personajeJson.getSpecies()
        );
    }
}
