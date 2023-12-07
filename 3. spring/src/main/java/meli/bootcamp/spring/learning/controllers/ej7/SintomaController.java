package meli.bootcamp.spring.learning.controllers.ej7;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import meli.bootcamp.spring.learning.entities.ej7.Sintoma;
import meli.bootcamp.spring.learning.services.ej7.SintomaService;

@RestController
@RequestMapping("ej7")
public class SintomaController {
  private SintomaService service;

  public SintomaController(SintomaService service) {
    this.service = service;
  }

  @GetMapping("findSymptom")
  public ResponseEntity<List<Sintoma>> findSymptom() {
    return ResponseEntity.ok(service.obtenerTodos());
  }

  @GetMapping("findSymptom/{name}")
  public ResponseEntity<Sintoma> findSymptomByName(@PathVariable String name) {
    Optional<Sintoma> posibleSintoma = service.obtenerPorNombre(name);
    if (posibleSintoma.isPresent()) {
      return ResponseEntity.ok(posibleSintoma.get());
    }
    return ResponseEntity.badRequest().body(null);
  }
}
