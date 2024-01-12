package com.meli.joyeria.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JoyaCompletaDTO {
    private Long id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    @JsonProperty("posee_piedra")
    private Boolean poseePiedra;
    private Boolean ventaONo;
}
