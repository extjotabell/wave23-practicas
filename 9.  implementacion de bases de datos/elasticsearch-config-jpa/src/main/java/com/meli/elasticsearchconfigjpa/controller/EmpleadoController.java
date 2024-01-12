package com.meli.elasticsearchconfigjpa.controller;

import com.meli.elasticsearchconfigjpa.entity.Empleado;
import com.meli.elasticsearchconfigjpa.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping
    public Empleado save(@RequestBody Empleado empleado){
        return empleadoService.save(empleado);
    }

    @GetMapping
    public List<Empleado> getAll(){
        return empleadoService.getAll();
    }

    @GetMapping("/find-by-edad/{edad}")
    public List<Empleado> findByEdad(@PathVariable String edad){
        return empleadoService.findByEdad(edad);
    }

    @GetMapping("/find-by-edad-mayor/{edad}")
    public List<Empleado> findByEdadMayor(@PathVariable String edad){
        return empleadoService.findByEdadMayor(edad);
    }

    @GetMapping("/find-by-name/{name}")
public List<Empleado> findByName(@PathVariable String name){
        return empleadoService.findByName(name);
    }
}
