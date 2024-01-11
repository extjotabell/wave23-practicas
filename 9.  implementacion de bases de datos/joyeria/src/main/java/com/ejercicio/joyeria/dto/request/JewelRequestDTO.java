package com.ejercicio.joyeria.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JewelRequestDTO {
    private String nombre;
    private String material;
    private double peso;
    private String particularidad;
    @JsonProperty("posee_piedra")
    private boolean poseePiedra;
    @JsonProperty("venta_o_no")
    private boolean ventaONo = true;
}
