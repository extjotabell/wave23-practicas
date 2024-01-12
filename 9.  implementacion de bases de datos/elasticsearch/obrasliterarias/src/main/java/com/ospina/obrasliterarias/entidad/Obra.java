package com.ospina.obrasliterarias.entidad;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Document(indexName = "empleados")
public class Obra {
    @Id
    String id;
    String nombre;
    String autor;
    String cantidadPaginas;
    String editorial;
    String anioPublicacion;
}
