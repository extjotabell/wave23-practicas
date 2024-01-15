package com.meli.crudjpaejemplo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class StudentsDTO {
    @JsonProperty("list_students")
    private List<StudentDTO> studentDTOS;
}
