package com.example.obrasliterarias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "literaryworks")
@TypeAlias("literaryWork")
public class LiteraryWork {
    @Id
    private Long id;
    private String title;
    private String author;
    private int pageCount;
    private String publisher;
    private int firstPublicationYear;
}
