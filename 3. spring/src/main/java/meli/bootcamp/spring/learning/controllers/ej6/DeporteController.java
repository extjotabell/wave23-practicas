package meli.bootcamp.spring.learning.controllers.ej6;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import meli.bootcamp.spring.learning.entities.ej6.Deporte;
import meli.bootcamp.spring.learning.services.ej6.DeporteService;

@RestController
@RequestMapping("ej6")
public class DeporteController {

  private DeporteService service;

  public DeporteController(DeporteService service) {
    this.service = service;
  }

  @GetMapping("findSports")
  public ResponseEntity<List<Deporte>> findSports() {
    return ResponseEntity.ok(this.service.getAll());
  }

  @GetMapping("findSports/{name}")
  public ResponseEntity<Deporte> findSportByName(@PathVariable String name) {
    Optional<Deporte> posibleDeporte = this.service.getByName(name);
    if (posibleDeporte.isPresent()) {
      return ResponseEntity.ok(posibleDeporte.get());
    } else {
      return ResponseEntity.badRequest().body(null);
    }
  }
}
