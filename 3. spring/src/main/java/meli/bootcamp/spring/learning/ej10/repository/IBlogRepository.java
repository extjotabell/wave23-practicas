package meli.bootcamp.spring.learning.ej10.repository;

import java.util.List;
import java.util.Optional;

import meli.bootcamp.spring.learning.ej10.entity.EntradaBlog;

public interface IBlogRepository {
  public void guardar(EntradaBlog blog);

  public Optional<EntradaBlog> obtenerPorId(Integer id);

  public List<EntradaBlog> obtenerTodos();
}
