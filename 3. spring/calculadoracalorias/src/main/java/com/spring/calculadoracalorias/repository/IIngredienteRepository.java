package com.spring.calculadoracalorias.repository;

import com.spring.calculadoracalorias.entity.Ingrediente;
import com.spring.calculadoracalorias.entity.Plato;

public interface IIngredienteRepository {
    Ingrediente buscarIngrediente(String nombre);

}
