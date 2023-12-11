package com.bootcamp.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonaRiesgoDTO {

    protected String nombreCompleto, sintoma;
    protected Integer edad, nivelGravedad;

}
