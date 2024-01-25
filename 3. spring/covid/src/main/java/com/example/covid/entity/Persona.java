package com.example.covid.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private Sintoma sintoma;
}
