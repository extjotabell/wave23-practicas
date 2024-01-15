package com.example.carga_literaria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "obra")
@TypeAlias("obra")
public class Obra {
    @Id
    private String id;

    private String name;

    private String author;

    private Integer pages;

    private String editorial;

    private Integer year;
}
