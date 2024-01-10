package com.ospina.joyeria.controlador;

import com.ospina.joyeria.modelo.entidad.Joya;
import com.ospina.joyeria.modelo.request.JoyaRequestDTO;
import com.ospina.joyeria.servicio.JoyaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JoyaControlador {

    private final JoyaServicio joyaServicio;

    public JoyaControlador(JoyaServicio joyaServicio) {
        this.joyaServicio = joyaServicio;
    }

    @PostMapping("/new")
    public ResponseEntity<String> crearJoya(@RequestBody JoyaRequestDTO joyaRequestDTO) {
        Long id = joyaServicio.guardarJoya(joyaRequestDTO);
        return new ResponseEntity<>("Joya creada con el ID: " + id, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Joya>> obtenerJoyas() {
        return new ResponseEntity<>(joyaServicio.obtenerJoyas(), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> borrarJoya(@PathVariable Long id) {
        joyaServicio.borrarJoya(id);
        return new ResponseEntity<>("Joya borrada con el ID: " + id, HttpStatus.OK);
    }
}
