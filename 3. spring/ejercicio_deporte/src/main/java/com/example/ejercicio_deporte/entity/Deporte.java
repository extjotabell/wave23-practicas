package com.example.ejercicio_deporte.entity;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Deporte {
    private String name;
    private String lvl;
    private List<Persona> participantes;
}