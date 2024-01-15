package com.example.obraliteraria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "obras_literarias")
@TypeAlias("obra_literaria")
public class ObraLiteraria {
    @Id
    String id;
    String nombre;
    Autor autor;
    int paginas;
    String editorial;
    int añoPublicacion;
}
