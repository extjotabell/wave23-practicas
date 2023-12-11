package com.bootcamp.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class PersonaDTO {

    protected String nombre, apellido, deporte;
    protected Integer edad;

}
