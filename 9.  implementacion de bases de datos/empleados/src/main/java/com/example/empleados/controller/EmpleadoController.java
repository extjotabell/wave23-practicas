package com.example.empleados.controller;

import com.example.empleados.entity.Empleado;
import com.example.empleados.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    /* Agregar nuevo empleado*/
    @PostMapping("/empleados/create")
    public Empleado save(@RequestBody Empleado empleado){
        return empleadoService.save(empleado);
    }

    /* Editar un empleado en particular */
    @PutMapping("/empleados/{id}")
    public Empleado update(@PathVariable String id, @RequestBody Empleado empleado){
        return empleadoService.update(id,empleado);
    }

    /* Listar todos los empleados */
    @GetMapping("/getAll")
    public List<Empleado> getAllEmpleados(){
        return empleadoService.getAll();
    }
}
