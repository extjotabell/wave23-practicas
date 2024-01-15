package com.example.literaryworks.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "literary_works")
@TypeAlias("literary_works")
public class LiteraryWorks {
    @Id
    private String id;
    private String nameLiteraryWorks;
    private String authorLiteraryWorks;
    private Integer quantityPagesLiteraryWorks;
    private String editorialLiteraryWorks;
    private Integer yearFirstEditionLiteraryWorks;
}