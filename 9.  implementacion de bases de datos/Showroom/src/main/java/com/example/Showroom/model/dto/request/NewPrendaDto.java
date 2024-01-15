package com.example.Showroom.model.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NewPrendaDto {
    @JsonProperty("nombre")
    String nombre;

    @JsonProperty("tipo")
    String tipo;

    @JsonProperty("marca")
    String marca;

    @JsonProperty("color")
    String color;

    @JsonProperty("talle")
    String talle;

    @JsonProperty("cantidad")
    Integer cantidad;

    @JsonProperty("precio_venta")
    double precio_venta;
}
