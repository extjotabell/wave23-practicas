package com.meli.elasticsearchobras.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "obras")
@TypeAlias("obra")
public class Obra {
    @Id
    private String id;
    private String nombre;
    private String autor;
    private String paginas;
    private String editorial;
    private String anioPublicacion;
}
