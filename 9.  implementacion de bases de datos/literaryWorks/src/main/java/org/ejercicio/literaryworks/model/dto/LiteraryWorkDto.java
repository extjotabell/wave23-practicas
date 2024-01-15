package org.ejercicio.literaryworks.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LiteraryWorkDto {
    private String id;
    private String name;
    private String author;
    private Integer pages;
    private String editorial;
    private Integer yearOfPublication;
}
