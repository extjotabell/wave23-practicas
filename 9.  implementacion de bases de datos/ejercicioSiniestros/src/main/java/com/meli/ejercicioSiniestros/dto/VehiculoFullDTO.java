package com.meli.ejercicioSiniestros.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.ejercicioSiniestros.model.Siniestro;
import jakarta.persistence.OneToMany;

import java.util.Set;

public class VehiculoFullDTO {
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anoFabricacion;
    private Integer cantidadRuedas;
    private Set<SiniestroBasicDTO> siniestros;
}
