package com.deportista.deportista.DTOS.Response;

import com.deportista.deportista.Entities.DeporteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PersonaDeportistaResponseDTO {
    private String nombre;
    private String apellido;
    private List<DeporteEntity> deportes;
}
