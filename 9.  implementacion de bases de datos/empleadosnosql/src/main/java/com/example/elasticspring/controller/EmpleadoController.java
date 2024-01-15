package com.example.elasticspring.controller;

import com.example.elasticspring.entity.Empleado;
import com.example.elasticspring.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping("/Empleados")
    public Empleado save(@RequestBody Empleado empleado){
        return empleadoService.save(empleado);
    }

    @GetMapping("/getAll")
    public List<Empleado> getAllEmpleados(){
        return empleadoService.getAll();
    }

    @GetMapping("/find-by-edad/{edad}")
    public List<Empleado> findByEdad(@PathVariable String edad) { return empleadoService.findByEdad(edad);}

    @GetMapping("/find-by-edad-mayor/{edad}")
    public List<Empleado> findByEdadMayor(@PathVariable String edad) { return empleadoService.findByEdadByRange(edad);}

    @GetMapping("/find-by-name/{nombre}")
    public List<Empleado> findByName(@PathVariable String nombre) { return empleadoService.findByNames(nombre);}

}
