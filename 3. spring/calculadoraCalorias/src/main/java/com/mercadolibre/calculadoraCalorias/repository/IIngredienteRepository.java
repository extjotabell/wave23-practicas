package com.mercadolibre.calculadoraCalorias.repository;

import com.mercadolibre.calculadoraCalorias.entity.Ingrediente;

import java.util.List;

public interface IIngredienteRepository {

    List<Ingrediente> buscarTodos();

    Ingrediente buscarIngrediente(String nombre);
}
