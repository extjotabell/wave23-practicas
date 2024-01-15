package com.example.ElasticSearch.controller;


import com.example.ElasticSearch.entity.Empleado;
import com.example.ElasticSearch.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping("/empleados")
    public Empleado save(@RequestBody Empleado empleado){
        return empleadoService.save(empleado);
    }

    @GetMapping("/getAll")
    public List<Empleado> getAllEmpleados(){
        return empleadoService.getAll();
    }

    @GetMapping("/find-by-edad/{edad}")
    public List<Empleado> findByEdad(@PathVariable String edad){
        return empleadoService.findByEdad(edad);
    }

    @GetMapping("/find-by-edad-mayor/{edad}")
    public List<Empleado> findByEdadMayor(@PathVariable String edad){
        return empleadoService.findByEdadRange(edad);
    }

    @GetMapping("/find-by-name/{name}")
    public List<Empleado> findByName(@PathVariable String name){
        return empleadoService.findByName(name);
    }

}
