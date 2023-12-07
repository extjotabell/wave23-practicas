package meli.bootcamp.spring.learning.controllers.ej4;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import meli.bootcamp.spring.learning.exceptions.ej4.MensajeInvalidoException;
import meli.bootcamp.spring.learning.services.ej4.CodigoMorseService;

@RestController
@RequestMapping("/ej4")
public class MorseController {
  private CodigoMorseService servicio;

  public MorseController(CodigoMorseService service) {
    this.servicio = service;
  }

  @PostMapping("/decode")
  public String decodificarMensaje(@RequestBody String mensaje) {
    return servicio.decodificar(mensaje);
  }

  @PostMapping("/encode")
  public ResponseEntity<String> codificarMensaje(@RequestBody String mensaje) {
    try {
      String encode = this.servicio.codificar(mensaje);
      return ResponseEntity.ok(encode);
    } catch (MensajeInvalidoException error) {
      // Loguear la excepción o manejarla de acuerdo a tus necesidades
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + error.getMessage());
    }
  }
}
