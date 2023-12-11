package meli.bootcamp.spring.learning.ej7.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import meli.bootcamp.spring.learning.ej7.dto.PersonaDto;
import meli.bootcamp.spring.learning.ej7.service.PersonaRiesgoService;

@RestController
@RequestMapping("ej7")
public class PersonaRiesgoController {
  private PersonaRiesgoService service;

  public PersonaRiesgoController(PersonaRiesgoService service) {
    this.service = service;
  }

  @GetMapping("findRiskPerson")
  public ResponseEntity<List<PersonaDto>> findRiskPerson() {
    return ResponseEntity.ok(service.obtenerPersonasRiesgo());
  }
}
