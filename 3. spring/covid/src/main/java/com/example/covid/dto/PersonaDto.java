package com.example.covid.dto;


import com.example.covid.entity.Sintoma;
import lombok.*;

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
