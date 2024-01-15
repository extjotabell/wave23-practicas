package com.example.obrasliterariasnosql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "obras-literarias")
@TypeAlias("obra-literaria")
public class ObraLiteraria {
    @Id
    private String id;
    private String nombre;
    private String autor;
    private Integer cantidadPaginas;
    private String editorial;
    private Integer anioPrimeraPublicacion;
}