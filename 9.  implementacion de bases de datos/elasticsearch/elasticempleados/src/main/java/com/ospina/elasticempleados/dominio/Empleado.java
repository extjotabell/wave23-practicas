package com.ospina.elasticempleados.dominio;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter @Setter
@Document(indexName = "empleados")
public class Empleado {

    @Id
    Long id;
    String nombre;
    String apellido;
    Integer edad;
    String cuidad;
    String departamento;
}
