package org.meli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.meli.model.Personaje;

@Getter @AllArgsConstructor
public class PersonajeResponseDTO {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;

    public static PersonajeResponseDTO personajeToDTO(Personaje personaje){
        return new PersonajeResponseDTO(
                personaje.getName(),
                personaje.getHeight(),
                personaje.getMass(),
                personaje.getGender(),
                personaje.getHomeworld(),
                personaje.getSpecies()
        );
    }
}
