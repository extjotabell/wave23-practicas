package com.calculadoraCalorias.calculadoraCalorias.repository;
import com.calculadoraCalorias.calculadoraCalorias.entity.Ingrediente;
import com.calculadoraCalorias.calculadoraCalorias.entity.Plato;

import java.util.List;

public interface IIngredienteRepository {
    List<Ingrediente> getAllIngredientes();
    List<Plato> getAllPlatos();
}
