package com.example.Covid19.DTOS;

import java.util.List;

public class PersonasSintomasDTO {
    private String nombreCompleto;

    private List<SintomaDTO> sintomas;

    public PersonasSintomasDTO(String nombreCompleto, List<SintomaDTO> sintomas) {
        this.nombreCompleto = nombreCompleto;
        this.sintomas = sintomas;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public List<SintomaDTO> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<SintomaDTO> sintomas) {
        this.sintomas = sintomas;
    }
}
