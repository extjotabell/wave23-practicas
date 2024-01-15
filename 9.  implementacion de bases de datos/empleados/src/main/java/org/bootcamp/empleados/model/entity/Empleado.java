package org.bootcamp.empleados.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "empleados")
@TypeAlias("empleado")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Empleado {

    @Id
    private String id;

    private String nombre;
    private String apellido;
    private Integer edad;
    private String ciudad;
    private String provincia;

}
