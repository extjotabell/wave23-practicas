package com.example.covid.dto;

import com.example.covid.entities.Gravedad;

public class SymptomDTO {
    private Gravedad gravedad;

    public SymptomDTO(Gravedad gravedad) {
        this.gravedad = gravedad;
    }

    public Gravedad getGravedad() {
        return gravedad;
    }
}
