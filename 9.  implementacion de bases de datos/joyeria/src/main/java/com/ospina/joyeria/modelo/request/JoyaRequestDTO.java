package com.ospina.joyeria.modelo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JoyaRequestDTO {
    @JsonProperty("nombre")
    String nombre;
    @JsonProperty("material")
    String material;
    @JsonProperty("peso")
    Double peso;
    @JsonProperty("particularidad")
    String particularidad;
    @JsonProperty("posee_piedra")
    Boolean poseePiedra;
}
