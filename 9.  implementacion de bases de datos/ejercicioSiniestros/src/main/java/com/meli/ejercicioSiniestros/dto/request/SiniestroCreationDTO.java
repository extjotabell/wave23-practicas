package com.meli.ejercicioSiniestros.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class SiniestroCreationDTO {
    private LocalDate fecha;
    private Double perdida;
    private Long vehiculoId;
}
