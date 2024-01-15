package com.mercadolibre.seguro_autos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiclePatentBrandDTO {
    private String patent;
    private String brand;
}
