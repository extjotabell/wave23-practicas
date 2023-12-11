package meli.bootcamp.spring.learning.ej6.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meli.bootcamp.spring.learning.ej6.dto.PersonaDto;
import meli.bootcamp.spring.learning.ej6.entity.Deporte;
import meli.bootcamp.spring.learning.ej6.entity.Persona;

@Service
public class PersonaService {
  @Autowired
  private DeporteService deporteService;

  private List<Persona> personas;

  public PersonaService(DeporteService deporteService) {
    this.deporteService = deporteService;
    this.personas = new ArrayList<>();
    List<Deporte> deportes = this.deporteService.getAll();
    Deporte depo1 = deportes.get(0);
    Deporte depo2 = deportes.get(1);
    Deporte depo3 = deportes.get(2);
    Deporte depo4 = deportes.get(3);
    personas.add(new Persona("Tiago", "Ramirez", 22, depo1));
    personas.add(new Persona("Tiago2", "Ramirez2", 222, depo2));
    personas.add(new Persona("Tiago3", "Ramirez3", 223, depo3));
    personas.add(new Persona("Tiago4", "Ramirez4", 224, depo4));
  }

  public List<PersonaDto> getAll() {
    List<PersonaDto> personaDtos = new ArrayList<PersonaDto>();
    this.personas
        .forEach(p -> personaDtos.add(new PersonaDto(p.getNombre(), p.getApellido(), p.getDeporte().getNombre())));
    return personaDtos;
  }

}
