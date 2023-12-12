package meli.bootcamp.spring.learning.ej9.repository;

import java.util.List;
import java.util.Optional;

import meli.bootcamp.spring.learning.ej9.entity.Ingrediente;

public interface IIngredienteRepository {
  public List<Ingrediente> obtenerTodos();

  public Optional<Ingrediente> obtenerPorNombre(String nombre);
}
