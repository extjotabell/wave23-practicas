package com.ospina.starWars;

import com.ospina.starWars.modelo.dto.PersonajeDTO;
import com.ospina.starWars.modelo.servicio.ServicioStarWars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/starWars")
public class ControladorStarWars {

    @Autowired
    ServicioStarWars ServicioStarWars;

    @GetMapping("buscar/{nombre}")
    public ResponseEntity<List<PersonajeDTO>> obtenerPersonajesPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(ServicioStarWars.buscarPersonajesPorNombre(nombre));

    }
}
