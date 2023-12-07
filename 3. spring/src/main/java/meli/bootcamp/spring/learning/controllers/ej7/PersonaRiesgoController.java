package meli.bootcamp.spring.learning.controllers.ej7;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import meli.bootcamp.spring.learning.dto.ej7.PersonaDto;
import meli.bootcamp.spring.learning.services.ej7.PersonaRiesgoService;

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
