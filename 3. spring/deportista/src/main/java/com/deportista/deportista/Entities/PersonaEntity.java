package com.deportista.deportista.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PersonaEntity {
    private String nombre;
    private String apellido;
    private Integer edad;
}
