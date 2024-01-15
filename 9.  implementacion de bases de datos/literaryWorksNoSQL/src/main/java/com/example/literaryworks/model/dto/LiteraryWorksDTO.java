package com.example.literaryworks.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class LiteraryWorksDTO {
    private String id;
    private String nameLiteraryWorks;
    private String authorLiteraryWorks;
    private Integer quantityPagesLiteraryWorks;
    private String editorialLiteraryWorks;
    private Integer yearFirstEditionLiteraryWorks;
}