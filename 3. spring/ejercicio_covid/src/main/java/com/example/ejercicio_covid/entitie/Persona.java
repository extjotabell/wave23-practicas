package com.example.ejercicio_covid.entitie;

import lombok.*;
import org.springframework.boot.web.server.SslStoreProvider;

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
