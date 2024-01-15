package com.meli.autoinsurance.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoDTO {
    private String patente;
    private String marca;
    private String modelo;
    private String anioDeFabricacion;
    private Integer cantidadDeRuedas;
}