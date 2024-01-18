package com.example.ejercicioEmpleadosNoSQL.service;

import com.example.ejercicioEmpleadosNoSQL.dto.EmpleadoDto;
import com.example.ejercicioEmpleadosNoSQL.dto.MessageDto;

import java.util.List;

public interface IEmpleadoService {

    MessageDto saveEmpleado(EmpleadoDto empleadoDto);
    List<EmpleadoDto> findAll();

}
