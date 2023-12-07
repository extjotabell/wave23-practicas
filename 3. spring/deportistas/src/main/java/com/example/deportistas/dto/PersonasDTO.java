package com.example.deportistas.dto;

import java.util.List;

public class PersonasDTO {
    private final List<PersonaDTO> personas;

    public PersonasDTO(List<PersonaDTO> personas) {
        this.personas = personas;
    }

    public List<PersonaDTO> getPersonas() {
        return personas;
    }
}
