package com.example.clasenosql.controller;

import com.example.clasenosql.entity.Empleado;
import com.example.clasenosql.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping("/add")
    public Empleado save(@RequestBody Empleado empleado){
        return empleadoService.save(empleado);
    }

    @GetMapping("/get-all")
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
