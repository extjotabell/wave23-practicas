package com.ospina.elasticempleados.controlador;

import com.ospina.elasticempleados.dominio.Empleado;
import com.ospina.elasticempleados.dominio.dto.EmpleadoDto;
import com.ospina.elasticempleados.servicio.EmpleadoServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/empleado")
public class EmpleadoControlador {

    private final EmpleadoServicio empleadoServicio;

    public EmpleadoControlador(EmpleadoServicio empleadoServicio) {
        this.empleadoServicio = empleadoServicio;
    }

    @PostMapping("/crear")
    public ResponseEntity<String> guardarEmpleado(@RequestBody EmpleadoDto empleadoDto) {
        empleadoServicio.guardarEmpleado(empleadoDto);
        return ResponseEntity.ok("Empleado creado exitosamente");
    }

    @GetMapping
    public ResponseEntity<Iterable<Empleado>> obtenerEmpleados() {
        return ResponseEntity.ok(empleadoServicio.obtenerEmpleados());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable String id, @RequestBody EmpleadoDto empleadoDto) {
        return ResponseEntity.ok(empleadoServicio.actualizarEmpleado(id, empleadoDto));
    }

}
