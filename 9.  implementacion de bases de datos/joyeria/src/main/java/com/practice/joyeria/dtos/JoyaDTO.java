package com.practice.joyeria.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoyaDTO {
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean posee_piedra;
    private Boolean venta_o_no;
}
