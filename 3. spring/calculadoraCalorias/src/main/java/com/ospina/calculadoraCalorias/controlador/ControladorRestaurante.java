package com.ospina.calculadoraCalorias.controlador;

import com.ospina.calculadoraCalorias.excepcion.PlatoNoEncontradoExcepcion;
import com.ospina.calculadoraCalorias.modelo.request.RequestPlato;
import com.ospina.calculadoraCalorias.servicio.ServicioComida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/restaurante")
public class ControladorRestaurante {

    private final ServicioComida servicioComida;

    @Autowired
    public ControladorRestaurante(ServicioComida servicioComida) {
        this.servicioComida = servicioComida;
    }

    @GetMapping("/obtenerDatos")
    public ResponseEntity<?> obtenerDatos(@RequestBody RequestPlato requestPlato) {
        try{
            return ResponseEntity.ok(servicioComida.obtenerDatos(requestPlato));
        } catch (PlatoNoEncontradoExcepcion e) {
            return ResponseEntity.badRequest().body("Error: "+ e.getMessage());
        }
    }
}
