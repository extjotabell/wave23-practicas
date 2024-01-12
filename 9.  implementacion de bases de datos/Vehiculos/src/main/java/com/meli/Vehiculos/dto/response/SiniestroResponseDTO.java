package com.meli.Vehiculos.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.Vehiculos.dto.request.VehiculoRequestDTO;
import com.meli.Vehiculos.model.Siniestro;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SiniestroResponseDTO implements Serializable {

    Long id;

    LocalDate fecha;

    @JsonProperty("perdida_economica")
    Double perdidaEconomica;

    VehiculoResponseDTO vehiculo;

    public SiniestroResponseDTO(Siniestro siniestro) {
        this.id = siniestro.getId();
        this.fecha = siniestro.getFecha();
        this.perdidaEconomica = siniestro.getPerdidaEconomica();
        this.vehiculo = new VehiculoResponseDTO(siniestro.getVehiculo());
    }
}