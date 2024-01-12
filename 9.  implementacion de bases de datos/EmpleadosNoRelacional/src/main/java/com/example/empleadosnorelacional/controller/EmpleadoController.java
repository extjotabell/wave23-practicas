package com.example.empleadosnorelacional.controller;

import com.example.empleadosnorelacional.entity.Empleado;
import com.example.empleadosnorelacional.service.EmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadoController {
  private final EmpleadoService service;

  public EmpleadoController(EmpleadoService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<?> save(Empleado empleado){
    return ResponseEntity.ok(service.save(empleado));
  }

  @GetMapping
  public ResponseEntity<?> getAll(){
    return ResponseEntity.ok(service.getAll());
  }
}
