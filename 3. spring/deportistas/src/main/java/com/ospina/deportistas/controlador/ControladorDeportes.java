package com.ospina.deportistas.controlador;

import com.ospina.deportistas.entidad.Deporte;
import com.ospina.deportistas.excepcion.DeporteNoEncontradoExcepcion;
import com.ospina.deportistas.servicio.deporte.DeporteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/deportes")
public class ControladorDeportes {

    @Autowired
    private DeporteServicio deporteServicio;

    @GetMapping("todos")
    public ResponseEntity<List<Deporte>> obtenerTodos() {
        return ResponseEntity.ok(deporteServicio.obtenerTodos());
    }

    @GetMapping("obtener/{nombre}")
    public ResponseEntity<?> obtenerPorNombre(@PathVariable String nombre) {
        try{
            return ResponseEntity.ok(deporteServicio.obtenerPorNombre(nombre));
        } catch (DeporteNoEncontradoExcepcion e) {
            return ResponseEntity.badRequest().body("Error: "+ e.getMessage());
        }
    }

}
