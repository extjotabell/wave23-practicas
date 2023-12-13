package com.mercadolibre.calculadoraCalorias.service;

import com.mercadolibre.calculadoraCalorias.dto.request.RecetaRequestDto;
import com.mercadolibre.calculadoraCalorias.dto.response.CaloriasResponseDto;
import com.mercadolibre.calculadoraCalorias.dto.response.IngredienteResponseDto;
import com.mercadolibre.calculadoraCalorias.dto.response.IngredientesResponseDto;

public interface ICalculadoraService {
    CaloriasResponseDto calcularCalorias(RecetaRequestDto receta) throws Exception;
    IngredientesResponseDto obtenerIngredientes(RecetaRequestDto receta) throws Exception;
    IngredienteResponseDto mayorCantidadDeCalorias(RecetaRequestDto request) throws Exception;
}
