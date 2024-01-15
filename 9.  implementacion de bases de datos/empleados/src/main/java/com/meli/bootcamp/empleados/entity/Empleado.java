package com.meli.bootcamp.empleados.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
@AllArgsConstructor
@Data
@Document(indexName = "empleados")
@TypeAlias("empleado")
public class Empleado {
    private String id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String cuidad;
    private String provincia;
}
