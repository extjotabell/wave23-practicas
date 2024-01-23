package com.example.ejercicioObrasLiterarias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObraLiterariaDto {

    private Integer id;
    private String nombre;
    private String autor;
    private Integer paginas;
    private String editorial;
    private Integer anioPublicacion;

}
