package meli.bootcamp.spring.learning.ej9.repository.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import meli.bootcamp.spring.learning.ej9.entity.Ingrediente;
import meli.bootcamp.spring.learning.ej9.repository.IIngredienteRepository;

@Repository
public class IngredienteRepository implements IIngredienteRepository {
  private List<Ingrediente> ingredientes;

  public IngredienteRepository() {
    this.ingredientes = load();
  }

  private List<Ingrediente> load() {
    File file = null;
    try {
      file = ResourceUtils.getFile("classpath:food.json");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    ObjectMapper objectMapper = new ObjectMapper();
    TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {
    };
    List<Ingrediente> ingredients = null;
    try {
      ingredients = objectMapper.readValue(file, typeRef);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return ingredients;
  }

  @Override
  public List<Ingrediente> obtenerTodos() {
    return this.ingredientes;
  }

  @Override
  public Optional<Ingrediente> obtenerPorNombre(String nombre) {
    return this.ingredientes
        .stream()
        .filter(i -> i.getName().equalsIgnoreCase(nombre))
        .findFirst();
  }
}
