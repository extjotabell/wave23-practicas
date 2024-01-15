package com.meli.bootcamp.empleados.controller;

import com.meli.bootcamp.empleados.dto.EmpleadoDto;
import com.meli.bootcamp.empleados.entity.Empleado;
import com.meli.bootcamp.empleados.service.EmpleadoServiceImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    private EmpleadoServiceImpl empleadoService;

    public EmpleadoController(EmpleadoServiceImpl empleadoService) {
        this.empleadoService = empleadoService;
    }

    @PostMapping("/add")
    public ResponseEntity<EmpleadoDto> save(@RequestBody EmpleadoDto empleadoDto){
        return new ResponseEntity<>(empleadoService.save(empleadoDto), HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<EmpleadoDto> updateEmpleadoById(@RequestBody EmpleadoDto empleadoDto){
        return new ResponseEntity<>(empleadoService.updateEmpleadoById(empleadoDto), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<EmpleadoDto>> findAll(){
        return new ResponseEntity<>(empleadoService.findAll(),HttpStatus.OK);
    }
}
