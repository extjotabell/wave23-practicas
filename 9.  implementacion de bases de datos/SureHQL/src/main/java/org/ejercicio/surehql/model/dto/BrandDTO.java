package org.ejercicio.surehql.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandDTO extends PatentDTO {
    private String brand;

    public BrandDTO(String patent, String brand) {
        super(patent);
        this.brand = brand;
    }
}
