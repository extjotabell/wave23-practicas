package com.bootcamp.ejercicioDeportistas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonaRequestDto {

    private String nombre;
    private String apellido;
    private Integer edad;

}
