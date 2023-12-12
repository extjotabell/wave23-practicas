package com.example.calculadoraCalorias.repository;

import com.example.calculadoraCalorias.entity.Ingrediente;
import com.example.calculadoraCalorias.entity.Plato;

import java.util.List;

public interface ICaloriasRepository {

   List<Ingrediente> getAll();

   List<Plato> getPlatos();

   Ingrediente getIngrediente(String nombre);

}
