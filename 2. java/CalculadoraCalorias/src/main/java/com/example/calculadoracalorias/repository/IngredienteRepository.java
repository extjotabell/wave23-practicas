package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.dto.IngredienteDTO;

public interface IngredienteRepository {
    IngredienteDTO findIngredienteByName(String name);
}
