package com.ospina.showroom.modelo.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class PrendaResponseDto {
    Long codigo;
    String nombre;
    String tipo;
    String marca;
    String color;
    String talle;
    int cantidad;
    @JsonProperty("precio_venta")
    double precioVenta;
}
