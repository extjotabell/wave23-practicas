package com.ospina.joyeria.controlador;

import com.ospina.joyeria.modelo.request.JoyaRequestDTO;
import com.ospina.joyeria.servicio.JoyaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
