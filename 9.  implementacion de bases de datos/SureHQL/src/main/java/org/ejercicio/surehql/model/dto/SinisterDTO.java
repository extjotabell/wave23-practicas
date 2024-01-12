package org.ejercicio.surehql.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SinisterDTO  {
    private Double total;
    private List<ModelDTO> vehicles;
}
