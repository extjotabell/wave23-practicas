package com.meli.elasticsearchconfigjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "empleados")
@TypeAlias("empleado")
public class Empleado {
    private String id;
    private String nombre;
    private String edad;
}