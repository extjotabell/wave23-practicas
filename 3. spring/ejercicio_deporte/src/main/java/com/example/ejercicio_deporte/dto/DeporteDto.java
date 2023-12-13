package com.example.ejercicio_deporte.dto;

import com.example.ejercicio_deporte.entity.Persona;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class DeporteDto {
    private String name;
    private String lvl;
    private List<Persona> participantes;
}
