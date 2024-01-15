package com.meli.autoinsurance.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoDTO {
    @JsonAlias("id_vehiculo")
    private Long idVehiculo;
    private String patente;
    private String marca;
    private String modelo;
    @JsonAlias("anio_de_fabricacion")
    private Integer anioDeFabricacion;
    @JsonAlias("cantidad_de_ruedas")
    private Integer cantidadDeRuedas;
}