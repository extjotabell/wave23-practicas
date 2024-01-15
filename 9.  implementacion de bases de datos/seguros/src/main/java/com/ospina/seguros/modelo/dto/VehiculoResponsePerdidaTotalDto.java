package com.ospina.seguros.modelo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;

@Value
public class VehiculoResponsePerdidaTotalDto {

    String matricula;
    String marca;
    String modelo;
    @JsonProperty("perdida_total")
    Double perdidaTotal;
}
