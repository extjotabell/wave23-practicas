package com.example.ejercicio_covid.dto;


import com.example.ejercicio_covid.entitie.Sintoma;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PersonaDto {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private Sintoma sintoma;
}
