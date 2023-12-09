package com.ejercicio.deportistas.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PersonSportDto {
    @JsonProperty("personName")
    private String fullNamePerson;
    @JsonProperty("sportName")
    private String nameSport;

    @Override
    public String toString() {
        return "Persona deportista " +
                "Persona: " + fullNamePerson + '\'' +
                "Deporte: " + nameSport + '\'';
    }
}
