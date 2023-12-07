package com.ospina.deportistas.controlador;

import com.ospina.deportistas.entidad.PersonaDeportistaDTO;
import com.ospina.deportistas.servicio.persona.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/personas")
public class ControladorPersona {

    @Autowired
    private PersonaServicio personaServicio;

    @GetMapping("todosDeportistas")
    public ResponseEntity<List<PersonaDeportistaDTO>> obtenerTodos() {
        return ResponseEntity.ok(personaServicio.obtenerTodos());
    }
}
