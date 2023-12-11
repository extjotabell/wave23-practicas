package meli.bootcamp.spring.learning.ej8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meli.bootcamp.spring.learning.ej8.dto.PersonajeResponseDto;
import meli.bootcamp.spring.learning.ej8.entity.Personaje;
import meli.bootcamp.spring.learning.ej8.repository.PersonajeRepository;

@Service
public class PersonajeService {

  @Autowired
  private PersonajeRepository repository;

  public List<PersonajeResponseDto> getPersonajeByNameLike(String name) {
    List<Personaje> respuesta = repository.findAllByNameContains(name);

    return respuesta.stream().map(p -> new PersonajeResponseDto(p.getName(),
        p.getHeight(), p.getMass(), p.getGender(), p.getHomeworld(), p.getSpecies())).toList();
  }
}
