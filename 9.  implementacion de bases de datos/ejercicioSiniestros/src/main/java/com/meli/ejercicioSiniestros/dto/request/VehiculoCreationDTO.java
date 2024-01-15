package com.meli.ejercicioSiniestros.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VehiculoCreationDTO {
    private String patente;
    private String marca;
    private String modelo;
    private Integer anoFabricacion;
    private Integer cantidadRuedas;
}
