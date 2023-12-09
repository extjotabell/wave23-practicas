package com.cifradoCesar.cifradoCesar.controller;
import com.cifradoCesar.cifradoCesar.entities.RequestCodificacion;
import com.cifradoCesar.cifradoCesar.servicio.Codificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cifrado")
public class ControllerCodificacion {

    @Autowired
    private Codificacion cifrado;

    @PostMapping("/codificacion")
    public ResponseEntity<String> codificacionMensaje(@RequestBody RequestCodificacion mensajerequest) {
        try {
            String mensaje = mensajerequest.getMensajerequest();
            if (mensaje == null) {
                return ResponseEntity.badRequest().body("El mensaje no puede ser nulo.");
            }
            mensaje = mensaje.toUpperCase().replaceAll("\\s", "");

            String codificacionClave23 = cifrado.codificacionConClave23(mensaje);
            String codificacionClave012 = cifrado.codificacionConClave012(mensaje);

            return ResponseEntity.ok("Mensaje con clave 23: " + codificacionClave23 + "\n" +
                    "Mensaje con clave 012: " + codificacionClave012);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al codificar mensaje: " + e.getMessage());
        }
    }
}
