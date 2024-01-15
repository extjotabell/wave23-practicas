package com.meli.bootcamp.empleados.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpleadoDto {
    private String id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String cuidad;
    private String provincia;
}
