package com.meli.bootcamp.obraliteraria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@AllArgsConstructor
@Data
@Document(indexName = "obras")
public class Obra {
    @Id
    private String id;
    private String nombre;
    private String autor;
    private Integer cantidadPaginas;
    private String editorial;
    private Integer fechaPublicacion;
}
