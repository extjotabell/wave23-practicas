package com.example.ejercicioEmpleadosNoSQL.controller;

import com.example.ejercicioEmpleadosNoSQL.dto.EmpleadoDto;
import com.example.ejercicioEmpleadosNoSQL.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    private IEmpleadoService empleadoService;

    @PostMapping
    public ResponseEntity<?> saveEmpleado(@RequestBody EmpleadoDto empleadoDto){
        return ResponseEntity.ok(empleadoService.saveEmpleado(empleadoDto));
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(empleadoService.findAll());
    }

}
