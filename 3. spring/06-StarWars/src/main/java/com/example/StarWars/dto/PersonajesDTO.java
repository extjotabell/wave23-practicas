package com.starwars.startwars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PersonajesDTO {
    private List<PersonajeDTO> personajes;
}