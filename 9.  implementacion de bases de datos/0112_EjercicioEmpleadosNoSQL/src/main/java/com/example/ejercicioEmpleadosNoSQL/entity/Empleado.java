package com.example.ejercicioEmpleadosNoSQL.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "empleados")
@TypeAlias("empleado")
public class Empleado {

    @Id
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String ciudad;
    private String estado;

}
