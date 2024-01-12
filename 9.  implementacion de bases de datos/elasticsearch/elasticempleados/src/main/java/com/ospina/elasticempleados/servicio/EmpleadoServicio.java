package com.ospina.elasticempleados.servicio;

import com.ospina.elasticempleados.dominio.Empleado;
import com.ospina.elasticempleados.dominio.dto.EmpleadoDto;
import com.ospina.elasticempleados.repositorio.EmpleadoRepositorio;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServicio {

    private final EmpleadoRepositorio empleadoRepositorio;

    public EmpleadoServicio(EmpleadoRepositorio empleadoRepositorio) {
        this.empleadoRepositorio = empleadoRepositorio;
    }

    public void guardarEmpleado(EmpleadoDto empleadoDto) {
        Empleado empleado = convertirEmpleadoDtoAEmpleado(empleadoDto);
        empleadoRepositorio.save(empleado);
    }

    public Iterable<Empleado> obtenerEmpleados() {
        return empleadoRepositorio.findAll();
    }

    public Empleado actualizarEmpleado(String id, EmpleadoDto empleadoDto) {
        Empleado empleado = empleadoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró un empleado con el id proporcionado: " + id));
        empleado.setNombre(empleadoDto.getNombre());
        empleado.setApellido(empleadoDto.getApellido());
        empleado.setEdad(empleadoDto.getEdad());
        empleado.setCuidad(empleadoDto.getCuidad());
        empleado.setDepartamento(empleadoDto.getDepartamento());
        empleadoRepositorio.save(empleado);
        return empleado;
    }

    private Empleado convertirEmpleadoDtoAEmpleado(EmpleadoDto empleadoDto) {
        Empleado empleado = new Empleado();
        empleado.setNombre(empleadoDto.getNombre());
        empleado.setApellido(empleadoDto.getApellido());
        empleado.setEdad(empleadoDto.getEdad());
        empleado.setCuidad(empleadoDto.getCuidad());
        empleado.setDepartamento(empleadoDto.getDepartamento());
        return empleado;
    }


}
