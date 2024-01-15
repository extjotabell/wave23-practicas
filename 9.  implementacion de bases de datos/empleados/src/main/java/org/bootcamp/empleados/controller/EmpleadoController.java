package org.bootcamp.empleados.controller;

import org.bootcamp.empleados.model.entity.Empleado;
import org.bootcamp.empleados.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("empleado")
public class EmpleadoController {

    @Autowired
    IEmpleadoService service;

    @PostMapping("/save")
    public Empleado saveEmpleado(@RequestBody Empleado empleado){
        return service.save(empleado);
    }

    @GetMapping("/getall")
    public List<Empleado> getAll(){
        return service.listAll();
    }

    @PutMapping("/update")
    public Empleado updateEmpleado(@RequestBody Empleado empleado){
        return service.update(empleado);
    }

}
