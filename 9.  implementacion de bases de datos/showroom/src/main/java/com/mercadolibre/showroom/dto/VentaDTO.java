package com.mercadolibre.showroom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO {
    private Integer numero;
    private LocalDate fecha;
    private Double total;
    private String medio_pago;
    private List<PrendaCodDTO> prendas;
}
