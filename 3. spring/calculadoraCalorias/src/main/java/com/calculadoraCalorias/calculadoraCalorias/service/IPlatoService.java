package com.calculadoraCalorias.calculadoraCalorias.service;
import com.calculadoraCalorias.calculadoraCalorias.dto.IngredienteDto;
import com.calculadoraCalorias.calculadoraCalorias.dto.PlatoDto;
import com.calculadoraCalorias.calculadoraCalorias.dto.PlatoResponseDto;

import java.util.List;

public interface IPlatoService {
    List<IngredienteDto> getAllIngredientes();
    List<PlatoResponseDto> getAllPlatos();
    PlatoResponseDto buscarPlato(String name, int weight);
    List<PlatoResponseDto> buscarListPlatos(List<PlatoDto> entradaPlato);
}
