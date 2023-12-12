package meli.bootcamp.spring.learning.ej9.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import meli.bootcamp.spring.learning.ej9.entity.Ingrediente;
import meli.bootcamp.spring.learning.ej9.entity.Plato;
import meli.bootcamp.spring.learning.ej9.repository.IIngredienteRepository;
import meli.bootcamp.spring.learning.ej9.repository.IPlatoRepository;

@Repository
public class PlatoRepository implements IPlatoRepository {
  private List<Plato> platos;

  private IIngredienteRepository ingredienteRepository;

  public PlatoRepository(IIngredienteRepository ingredienteRepository) {
    this.ingredienteRepository = ingredienteRepository;
    this.platos = load();
  }

  private List<Plato> load() {
    List<Ingrediente> ingredientes = ingredienteRepository.obtenerTodos();

    List<Ingrediente> ingredientes1 = List.of(ingredientes.get(0), ingredientes.get(32), ingredientes.get(50));
    Plato plato1 = new Plato("Pasta", ingredientes1);

    List<Ingrediente> ingredientes2 = List.of(ingredientes.get(34), ingredientes.get(45), ingredientes.get(61));
    Plato plato2 = new Plato("Arroz con pollo", ingredientes2);

    List<Ingrediente> ingredientes3 = List.of(ingredientes.get(2), ingredientes.get(65), ingredientes.get(11));
    Plato plato3 = new Plato("Sopa de tomate", ingredientes3);

    return List.of(plato1, plato2, plato3);
  }

  @Override
  public List<Plato> obtenerTodos() {
    return this.platos;
  }

  @Override
  public Optional<Plato> obtenerPorNombre(String nombre) {
    return this.platos
        .stream()
        .filter(i -> i.getNombre().equalsIgnoreCase(nombre))
        .findFirst();
  }
}