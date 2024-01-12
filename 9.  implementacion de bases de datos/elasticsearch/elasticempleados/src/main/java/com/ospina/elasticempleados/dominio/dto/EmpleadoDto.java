package com.ospina.elasticempleados.dominio.dto;

import lombok.Value;

@Value
public class EmpleadoDto {
    String nombre;
    String apellido;
    Integer edad;
    String cuidad;
    String departamento;

}
