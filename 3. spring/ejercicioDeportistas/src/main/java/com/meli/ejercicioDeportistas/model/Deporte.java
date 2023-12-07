package com.meli.ejercicioDeportistas.model;

import com.meli.ejercicioDeportistas.model.dto.DeporteResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Deporte {
    private String nombre;
    private String nivel;

    public DeporteResponseDTO toResponseDTO(){
        return new DeporteResponseDTO(nombre, nivel);
    }
}
