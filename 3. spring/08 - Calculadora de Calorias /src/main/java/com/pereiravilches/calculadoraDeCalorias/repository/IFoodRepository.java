package com.pereiravilches.calculadoraDeCalorias.repository;

import com.pereiravilches.calculadoraDeCalorias.entity.Ingrediente;
import com.pereiravilches.calculadoraDeCalorias.entity.Plato;

import java.util.List;


public interface IFoodRepository {

    Plato findPlatoByName(String name);
    List<Ingrediente> findAll();

    List<Plato> findAllPlatos();

}
