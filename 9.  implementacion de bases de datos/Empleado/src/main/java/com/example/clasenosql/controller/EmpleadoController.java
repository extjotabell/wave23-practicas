package com.example.clasenosql.controller;

import com.example.clasenosql.entity.Empleado;
import com.example.clasenosql.service.EmpleadoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadoController {

  @Autowired
  private EmpleadoService empleadoService;

  @PostMapping("/Empleados")
  public Empleado save(@RequestBody Empleado empleado) {
    return empleadoService.save(empleado);
  }

  @GetMapping("/getAll")
  public List<Empleado> getAllEmpleados() {
    return empleadoService.getAll();
  }

  @GetMapping("/find-by-edad/{edad}")
  public List<Empleado> findByEdad(@PathVariable String edad) {
    return empleadoService.findByEdad(edad);
  }

  @GetMapping("/find-by-edad-mayor/{edad}")
  public List<Empleado> findByEdadMayor(@PathVariable String edad) {
    return empleadoService.findByEdadByRange(edad);
  }

  @GetMapping("/find-by-name/{nombre}")
  public List<Empleado> findByName(@PathVariable String nombre) {
    return empleadoService.findByNames(nombre);
  }

  @PutMapping("/update-by-id/{id}")
  public Empleado updateById(@PathVariable String id, @RequestBody Empleado empleado) {
    return empleadoService.updateEmpleadoById(id,empleado);
  }
}
