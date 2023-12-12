package meli.bootcamp.spring.learning.ej9.repository;

import java.util.List;
import java.util.Optional;

import meli.bootcamp.spring.learning.ej9.entity.Plato;

public interface IPlatoRepository {
  public List<Plato> obtenerTodos();

  public Optional<Plato> obtenerPorNombre(String nombre);
}
