package com.example.clasenosql.service;

import com.example.clasenosql.entity.Empleado;

import java.util.List;

public interface IEmpleadoService {
    Empleado save(Empleado empleado);
    List<Empleado> getAll();
    List<Empleado> findByEdad(String edad);
    List<Empleado> findByEdadByRange(String edad);
    List<Empleado> findByNames(String nombre);
}
