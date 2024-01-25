package com.example.covid.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class SintomaDto {
    private int code;
    private String name;
    private String severidad;
}
