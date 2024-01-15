package com.ospina.showroom.modelo.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;

@Value
public class VentaResponseDto {

    Long numero;
    String fecha;
    double total;
    @JsonProperty("medio_pago")
    String medioPago;
    @JsonProperty("ids_prendas")
    List<Long> idsPrendas;
}
