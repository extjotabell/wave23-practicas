package com.example.ejercicio_covid.entitie;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class Sintoma {
    private int code;
    private String name;
    private String lvl;
}
