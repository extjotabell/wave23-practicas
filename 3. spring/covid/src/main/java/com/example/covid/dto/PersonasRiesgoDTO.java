package com.example.covid.dto;

import java.util.List;

public class PersonasRiesgoDTO {

    private List<PersonaRiesgoDTO> personas;

    public PersonasRiesgoDTO(List<PersonaRiesgoDTO> personas) {
        this.personas = personas;
    }

    public List<PersonaRiesgoDTO> getPersonas() {
        return personas;
    }

    public static class PersonaRiesgoDTO {
        private String nombre;
        private String apellido;

        public PersonaRiesgoDTO(String nombre, String apellido) {
            this.nombre = nombre;
            this.apellido = apellido;
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellido() {
            return apellido;
        }
    }
}
