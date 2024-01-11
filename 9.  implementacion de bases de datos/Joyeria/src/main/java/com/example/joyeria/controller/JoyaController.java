package com.example.joyeria.controller;

import com.example.joyeria.dto.JoyaRequestDTO;
import com.example.joyeria.service.JoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewelry")
public class JoyaController {

    private final JoyaService joyaService;

    public JoyaController(JoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> nuevaJoya(@RequestBody JoyaRequestDTO joyaRequestDTO) {
        Long id = joyaService.nuevaJoya(joyaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @GetMapping
    public ResponseEntity<?> joyas() {
        return ResponseEntity.ok(joyaService.joyas());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarJoya(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> actualizarJoya(@PathVariable Long id, @RequestBody JoyaRequestDTO joyaRequestDTO) {
        return ResponseEntity.ok().body(joyaService.actualizarJoya(id, joyaRequestDTO));
    }
}
