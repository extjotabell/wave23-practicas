package com.mercadolibre.demo.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class JewelDTO {
    private Long nro_id;
    private String nombre;
    private String material;
    private float peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean venta_o_no;
}
