package com.meli.ejercicioDeportistas.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class DeporteListResponseDTO {
    private List<DeporteResponseDTO> deportes;
}
