package com.bootcamp.covid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data @AllArgsConstructor
public class PersonDTO {
    private String fullName;
    private int age;
    private List<SymptomDTO> symptomDTOList;
}
