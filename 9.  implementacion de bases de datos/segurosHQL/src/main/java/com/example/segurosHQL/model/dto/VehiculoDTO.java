package com.example.segurosHQL.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class VehiculoDTO {
    private Long id;
    private String patente;
    private String marca;
    private  String modelo;
    private String matricula;
    private Integer anioFabricacion;
    private Integer cantidadRuedas;

}
