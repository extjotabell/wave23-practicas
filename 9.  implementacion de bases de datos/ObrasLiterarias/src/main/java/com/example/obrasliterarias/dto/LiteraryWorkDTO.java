package com.example.obrasliterarias.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LiteraryWorkDTO {
    private Long id;
    private String title;
    private String author;
    private int pageCount;
    private String publisher;
    private int firstPublicationYear;
}
