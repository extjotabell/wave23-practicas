package com.example.ejercicioEmpleadosNoSQL.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDto {

    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String ciudad;
    private String estado;

}
