package com.meli.Vehiculos.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.Vehiculos.model.Siniestro;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data @AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SiniestroRequestDTO implements Serializable {

    LocalDate fecha;

    @JsonProperty("perdida_economica")
    Double perdidaEconomica;

    @JsonProperty("vehiculo_id")
    Long vehiculoId;
}