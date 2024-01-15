package com.meli.Empleados.service;

import com.meli.Empleados.dto.EmpleadoDto;

import java.util.List;

public interface EmpleadoService {

    List<EmpleadoDto> findAll();
    EmpleadoDto findById(String id);
    EmpleadoDto save(EmpleadoDto empleado);
    void deleteById(String id);

}
