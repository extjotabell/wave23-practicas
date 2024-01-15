package com.example.obrasLiterarias.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "obras")
@TypeAlias("obra_literaria")
public class ObraLiteraria {
    @Id
    private String id;
    private String nombre;
    private String autor;
    private Integer cantidadPaginas;
    private String editorial;
    private Integer anioPublicacion;

}

