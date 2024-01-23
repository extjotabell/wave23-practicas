package com.example.ejercicioObrasLiterarias.model;

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
@Document(indexName = "obras_literarias")
@TypeAlias("obra_literaria")
public class ObraLiteraria {

    @Id
    private Integer id;
    private String nombre;
    private String autor;
    private Integer paginas;
    private String editorial;
    private Integer anioPublicacion;

}
