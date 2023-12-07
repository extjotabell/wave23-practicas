package com.meli.ejercicioDeportistas.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PersonaListResponseDTO {
    private List<PersonaResponseDTO> personas;

}
