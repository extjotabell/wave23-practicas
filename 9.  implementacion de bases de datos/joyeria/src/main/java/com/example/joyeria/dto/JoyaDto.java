package com.example.joyeria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoyaDto {
    Long nro_identificatorio;
    String nombre;
    String material;
    Long peso;
    String particularidad;
    String posee_piedra;
    boolean ventaONo;
}
