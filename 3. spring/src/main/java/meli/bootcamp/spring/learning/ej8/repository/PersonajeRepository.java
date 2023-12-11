package meli.bootcamp.spring.learning.ej8.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import meli.bootcamp.spring.learning.ej8.entity.Personaje;

@Repository
public class PersonajeRepository {
  private List<Personaje> personajes;

  public PersonajeRepository() {
    this.personajes = load();
  }

  public List<Personaje> findAllByNameContains(String query) {
    return personajes.stream()
        .filter(personaje -> matchWith(query, personaje)).toList();
  }

  private boolean matchWith(String query, Personaje personaje) {
    return personaje.getName().toUpperCase().contains(query.toUpperCase());
  }

  private List<Personaje> load() {
    File file = null;
    try {
      file = ResourceUtils.getFile("classpath:starwars.json");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    ObjectMapper objectMapper = new ObjectMapper();
    TypeReference<List<Personaje>> typeRef = new TypeReference<>() {
    };
    List<Personaje> characters = null;
    try {
      characters = objectMapper.readValue(file, typeRef);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return characters;
  }
}
