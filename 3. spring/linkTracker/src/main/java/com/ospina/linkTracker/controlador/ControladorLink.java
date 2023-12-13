package com.ospina.linkTracker.controlador;

import com.ospina.linkTracker.servicio.ServicioLink;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/link")
public class ControladorLink {

    private final ServicioLink servicioLink;

    public ControladorLink(ServicioLink servicioLink) {
        this.servicioLink = servicioLink;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearLink(@RequestParam String url,
                                       @RequestParam(required = false) String password) {
        int id = servicioLink.crearLink(url, password);
        return new ResponseEntity<>(Map.of("linkId", id), HttpStatus.OK);

    }

    @PostMapping("/{linkId}")
    public ResponseEntity<?> redireccionarLink(@PathVariable int linkId,
                                               @RequestParam(required = false) String password) {
        String url = servicioLink.redireccionarLink(linkId, password);
        return new ResponseEntity<>(Map.of("url", url), HttpStatus.OK);
    }

    @GetMapping("/estadisticas/{linkId}")
    public ResponseEntity<?> obtenerEstadisticas(@PathVariable int linkId) {
        Map<String, Integer> estadisticas = servicioLink.obtenerEstadisticas(linkId);
        return new ResponseEntity<>(estadisticas, HttpStatus.OK);
    }

    @PostMapping("/invalidar/{linkId}")
    public ResponseEntity<?> invalidarLink(@PathVariable int linkId) {
        servicioLink.invalidarLink(linkId);
        return new ResponseEntity<>("El link fue invalidado correctamente.",HttpStatus.OK);
    }
}
