package com.example.empleadoselasctic.controller;

import com.example.empleadoselasctic.entity.Empleado;
import com.example.empleadoselasctic.service.EmpleadoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    private final EmpleadoService empleadoService;

    public Controller(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

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
