package com.meli.calorias.repository;

import com.meli.calorias.entity.Ingrediente;
import com.meli.calorias.entity.Plato;

import java.util.List;

public interface CaloriasRepository {
    List<Ingrediente> loadIngredientes();

    Plato getPlato(String nombre);
}
