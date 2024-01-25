package com.example.covid.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class Sintoma {
    private int code;
    private String name;
    private String severidad;
}
