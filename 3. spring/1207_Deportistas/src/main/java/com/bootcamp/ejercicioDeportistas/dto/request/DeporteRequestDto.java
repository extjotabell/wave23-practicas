package com.bootcamp.ejercicioDeportistas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DeporteRequestDto {
    private String nombre;
    private Integer nivel;

    @Override
    public String toString() {
        return "DeporteRequestDto{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                '}';
    }
}
