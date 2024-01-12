package com.example.obrasliterariaselastic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "obras")
@TypeAlias("obra")
public class Obra {
    @Id
    private String id;
    private String titulo;
    @Field(type = FieldType.Nested, includeInParent = true)
    private Autor autor;
    @Field(type = FieldType.Nested, includeInParent = true)
    private Editorial editorial;
    private Integer fecha;
    private Integer paginas;
}
