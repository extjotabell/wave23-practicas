package com.example.deportistas.dto;

import com.example.deportistas.entities.Deporte;

import java.util.List;

public class DeportesDTO {
    private final List<Deporte> deportes;

    public DeportesDTO(List<Deporte> deportes) {
        this.deportes = deportes;
    }

    public List<Deporte> getDeportes() {
        return deportes;
    }
}
