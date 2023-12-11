package meli.bootcamp.spring.learning.ej8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import meli.bootcamp.spring.learning.ej8.dto.PersonajeResponseDto;
import meli.bootcamp.spring.learning.ej8.service.PersonajeService;

@RestController
@RequestMapping("ej8")
public class PersonajeController {
  @Autowired
  private PersonajeService service;

  @GetMapping("{name}")
  public ResponseEntity<List<PersonajeResponseDto>> getByNameLike(@PathVariable String name) {
    return ResponseEntity.ok(service.getPersonajeByNameLike(name));
  }
}
