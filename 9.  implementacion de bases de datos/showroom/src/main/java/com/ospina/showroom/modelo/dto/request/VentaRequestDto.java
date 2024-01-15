package com.ospina.showroom.modelo.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;

@Value
public class VentaRequestDto {
    String fecha;
    double total;
    @JsonProperty("medio_pago")
    String medioPago;
    List<PrendaReferenciaDto> prendas;
}
