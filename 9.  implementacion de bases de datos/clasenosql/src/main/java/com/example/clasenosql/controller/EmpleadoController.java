package com.example.clasenosql.controller;

import com.example.clasenosql.entity.Empleado;
import com.example.clasenosql.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    // crear empleado
    @PostMapping("/Empleados")
    public Empleado save(@RequestBody Empleado empleado){
        return empleadoService.save(empleado);
    }

    // obtener todos los empleados
    @GetMapping("/getAll")
    public List<Empleado> getAllEmpleados(){
        return empleadoService.getAll();
    }

    // obtener todos los empleados por edad
    @GetMapping("/find-by-edad/{edad}")
    public List<Empleado> findByEdad(@PathVariable String edad) { return empleadoService.findByEdad(edad);}

    // obtener todos los empleados por edad mayor que
    @GetMapping("/find-by-edad-mayor/{edad}")
    public List<Empleado> findByEdadMayor(@PathVariable String edad) { return empleadoService.findByEdadByRange(edad);}

    // obtener todos los empleados por nombre
    @GetMapping("/find-by-name/{nombre}")
    public List<Empleado> findByName(@PathVariable String nombre) { return empleadoService.findByNames(nombre);}

}
