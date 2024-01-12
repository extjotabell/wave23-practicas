package org.ejercicio.surehql.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelDTO extends BrandDTO {
    private String model;

    public ModelDTO(String patent, String brand, String model) {
        super(patent, brand);
        this.model = model;
    }
}
