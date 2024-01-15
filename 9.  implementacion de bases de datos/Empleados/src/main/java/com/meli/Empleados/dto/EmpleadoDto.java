package com.meli.Empleados.dto;

import com.meli.Empleados.entity.Empleado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDto implements Serializable {
    String id;
    String nombre;
    String apellido;
    int edad;
    String ciudad;
    String provincia;

    public EmpleadoDto(String nombre, String apellido, int edad, String ciudad, String provincia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ciudad = ciudad;
        this.provincia = provincia;
    }

    public EmpleadoDto(Empleado empleado) {
        this.id = empleado.getId();
        this.nombre = empleado.getNombre();
        this.apellido = empleado.getApellido();
        this.edad = empleado.getEdad();
        this.ciudad = empleado.getCiudad();
        this.provincia = empleado.getProvincia();
    }
}