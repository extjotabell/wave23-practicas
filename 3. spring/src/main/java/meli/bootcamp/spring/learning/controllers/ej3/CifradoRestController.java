package meli.bootcamp.spring.learning.controllers.ej3;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import meli.bootcamp.spring.learning.controllers.ej3.dto.Mensaje;

@RestController
@RequestMapping("ej3")
public class CifradoRestController {
  @PostMapping()
  public String cifrado(@RequestBody Mensaje mensajeDto) {

    String clave = mensajeDto.getClave().toUpperCase();

    String mensaje = mensajeDto.getMensaje();

    int n = clave.length();

    String cifrado = "";
    int pos = 0;
    for (int i = 0; i < mensaje.length(); i++) {
      if (mensaje.charAt(i) != ' ') {
        int desplazamiento = clave.charAt(pos) - '0';
        char c = (char) ((int) mensaje.charAt(i) + desplazamiento);
        cifrado += c;
        pos = (pos + 1) % n;
      }
    }
    return cifrado;
  }
}
