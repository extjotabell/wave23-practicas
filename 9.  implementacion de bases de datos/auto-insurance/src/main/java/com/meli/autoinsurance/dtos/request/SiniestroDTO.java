package com.meli.autoinsurance.dtos.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SiniestroDTO {
    @JsonAlias("id_siniestro")
    private Long idSiniestro;
    @JsonAlias("fecha_siniestro")
    private LocalDate fechaSiniestro;
    @JsonAlias("perdida_economica")
    private Double perdidaEconomica;
    @JsonAlias("id_vehiculo_denunciado")
    private Long idVehiculoDenunciado;

}
