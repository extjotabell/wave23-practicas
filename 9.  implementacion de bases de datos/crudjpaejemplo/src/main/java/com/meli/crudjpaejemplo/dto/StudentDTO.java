package com.meli.crudjpaejemplo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StudentDTO {

    @JsonProperty("student_dni")
    private String dni;
    @JsonProperty("student_name")
    private String name;
    @JsonProperty("stundet_last_name")
    private String lastName;

}
