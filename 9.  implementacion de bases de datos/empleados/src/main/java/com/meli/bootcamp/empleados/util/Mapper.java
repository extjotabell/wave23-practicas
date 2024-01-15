package com.meli.bootcamp.empleados.util;

import com.meli.bootcamp.empleados.dto.EmpleadoDto;
import com.meli.bootcamp.empleados.entity.Empleado;

public class Mapper {
    public static EmpleadoDto mapToEmpleadoDTO(Empleado empleado){
        if(empleado == null) return null;
        return new EmpleadoDto(empleado.getId(), empleado.getNombre(), empleado.getApellido(), empleado.getEdad(), empleado.getCuidad(), empleado.getProvincia());
    }
    public static Empleado mapToEmpleado(EmpleadoDto empleadoDto){
        if(empleadoDto == null) return null;
        return new Empleado(empleadoDto.getId(), empleadoDto.getNombre(), empleadoDto.getApellido(), empleadoDto.getEdad(), empleadoDto.getCuidad(), empleadoDto.getProvincia());
    }
}
