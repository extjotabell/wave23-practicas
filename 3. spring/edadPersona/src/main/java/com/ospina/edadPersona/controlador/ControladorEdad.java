package com.ospina.edadPersona.controlador;

import com.ospina.edadPersona.entidad.RequestPersona;
import com.ospina.edadPersona.entidad.ResponsePersona;
import com.ospina.edadPersona.excepcion.FechaNacimientoInvalidaException;
import com.ospina.edadPersona.servicio.ServicioEdad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
