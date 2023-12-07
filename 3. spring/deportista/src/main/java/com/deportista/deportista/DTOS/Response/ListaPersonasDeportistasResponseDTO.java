package com.deportista.deportista.DTOS.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ListaPersonasDeportistasResponseDTO {
    private List<PersonaDeportistaResponseDTO> personasDeportistas;
}
