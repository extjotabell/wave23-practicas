package com.edadPersona.controlador;

import com.edadPersona.entidad.ResponsePersona;
import com.edadPersona.entidad.RequestPersona;
import com.edadPersona.excepcion.FechaNacimientoInvalidaException;
import com.edadPersona.servicio.ServicioEdad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/edad")
public class ControladorEdad {

    @Autowired
    private ServicioEdad servicioEdad;

    @PostMapping
    public ResponseEntity<?> calcularEdad(@RequestBody RequestPersona requestPersona) {
        try{
            Integer edad = servicioEdad.calcularEdad(requestPersona.getDia(), requestPersona.getMes(), requestPersona.getAnio());
            return ResponseEntity.ok(new ResponsePersona(requestPersona.getNombre(), requestPersona.getApellido(), edad));
        } catch (FechaNacimientoInvalidaException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: "+ e.getMessage());
        }

    }

    @GetMapping("/{nombre}/{apellido}/{dia}/{mes}/{anio}")
    public ResponseEntity<?> calcularEdadG(@PathVariable String nombre,
                                           @PathVariable String apellido,
                                           @PathVariable Integer dia,
                                           @PathVariable Integer mes,
                                           @PathVariable Integer anio) {
        try{
            Integer edad = servicioEdad.calcularEdad(dia, mes, anio);
            return ResponseEntity.ok(new ResponsePersona(nombre, apellido, edad));
        } catch (FechaNacimientoInvalidaException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: "+ e.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity<?> calcularEdadWParams(@RequestParam String nombre,
                                                 @RequestParam String apellido,
                                                 @RequestParam Integer dia,
                                                 @RequestParam Integer mes,
                                                 @RequestParam Integer anio) {
        try {
            Integer edad = servicioEdad.calcularEdad(dia, mes, anio);
            return ResponseEntity.ok(new ResponsePersona(nombre, apellido, edad));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    // Si enviamos un String en lugar de Integer
    //    "status": 400,
    //    "error": "Bad Request",
    //    "message": "Type mismatch.",

}
