package com.meli.Empleados.controller;

import com.meli.Empleados.dto.EmpleadoDto;
import com.meli.Empleados.dto.MessageDto;
import com.meli.Empleados.service.EmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoService service;

    public EmpleadoController(EmpleadoService service) {
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<EmpleadoDto> create(@RequestBody EmpleadoDto empleadoDto) {
        EmpleadoDto empleado = service.save(empleadoDto);
        return ResponseEntity.ok(empleado);
    }

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        List<EmpleadoDto> empleados = service.findAll();
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        EmpleadoDto empleado = service.findById(id);
        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        service.deleteById(id);
        MessageDto message = new MessageDto("Empleado eliminado");
        return ResponseEntity.ok(message);
    }

}
