package org.ejercicio.literaryworks.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "literaryworks")
@TypeAlias("literarywork")
public class LiteraryWork {
    @Id
    private String id;
    private String name;
    private String author;
    private Integer pages;
    private String editorial;
    private Integer yearOfPublication;
}
