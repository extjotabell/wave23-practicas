package com.spring.elasticsearch.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "empleados")
@TypeAlias("empleado")
public class Empleado {

    @Id
    private String id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String ciudad;
}
