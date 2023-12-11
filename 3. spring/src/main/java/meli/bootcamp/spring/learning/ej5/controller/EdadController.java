package meli.bootcamp.spring.learning.ej5.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import meli.bootcamp.spring.learning.ej5.service.EdadService;

@RestController
@RequestMapping("ej5")
public class EdadController {
  private EdadService service;

  public EdadController(EdadService service) {
    this.service = service;
  }

  @GetMapping("{dia}/{mes}/{anio}")
  public ResponseEntity<Integer> calcularEdad(
      @PathVariable Integer dia,
      @PathVariable Integer mes,
      @PathVariable Integer anio) {

    return ResponseEntity.ok(service.calcular(dia, mes, anio));
  }
}
