package meli.bootcamp.spring.learning.controllers.ej6;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import meli.bootcamp.spring.learning.dto.ej6.PersonaDto;
import meli.bootcamp.spring.learning.services.ej6.PersonaService;

@RestController
@RequestMapping("ej6")
public class PersonaController {
  private PersonaService service;

  public PersonaController(PersonaService service) {
    this.service = service;
  }

  @GetMapping("findSportsPersons")
  public ResponseEntity<List<PersonaDto>> findSportsPersons() {
    return ResponseEntity.ok(service.getAll());
  }
}
