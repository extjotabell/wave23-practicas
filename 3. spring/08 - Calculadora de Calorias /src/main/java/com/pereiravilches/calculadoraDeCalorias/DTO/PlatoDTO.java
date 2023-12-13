package com.pereiravilches.calculadoraDeCalorias.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor @AllArgsConstructor @Data
public class PlatoDTO {
    private String nombre;
    private List<IngredienteDTO> ingredienteList;
}
