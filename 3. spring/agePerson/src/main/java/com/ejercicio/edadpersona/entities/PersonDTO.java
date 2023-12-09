package com.ejercicio.edadpersona.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PersonDTO {
    @JsonProperty("nombreCompleto")
    private String nombreCompleto;
    @JsonProperty("edad")
    private Integer edad;

}
