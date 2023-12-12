package com.mercadolibre.calculadoraCalorias.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class PlatoRequestDto {
    private String nombre;
    private Double gramos;

}
