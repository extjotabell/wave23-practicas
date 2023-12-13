package com.mercadolibre.calculadoraCalorias.repository;

import com.mercadolibre.calculadoraCalorias.entity.Receta;

public interface IRecetaRepository {
    Receta buscarReceta(String nombre) throws Exception;
}
