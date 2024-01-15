package com.meli.bootcamp.empleados.service;

import com.meli.bootcamp.empleados.dto.EmpleadoDto;
import com.meli.bootcamp.empleados.entity.Empleado;

import java.util.List;

public interface IEmpleadoService {
    EmpleadoDto save(EmpleadoDto empleadoDto);
    EmpleadoDto updateEmpleadoById(EmpleadoDto empleadoDto);
    List<EmpleadoDto> findAll();
}
