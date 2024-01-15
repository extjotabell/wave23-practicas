package org.bootcamp.empleados.service;

import org.bootcamp.empleados.model.entity.Empleado;

import java.util.List;

public interface IEmpleadoService {

    Empleado save(Empleado empleado);

    List<Empleado> listAll();

    Empleado update(Empleado empleado);

}
