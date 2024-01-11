package org.ejercicio.joyeria.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JewerlyDTO {
    private String name;
    private String material;
    private Double weight;
    private String particularity;
    private Boolean hasStone;
    private Boolean saleOrNot;
}
