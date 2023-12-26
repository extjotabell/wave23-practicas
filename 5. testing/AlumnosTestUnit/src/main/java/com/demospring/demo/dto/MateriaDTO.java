package com.demospring.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MateriaDTO {

    @Size(min = 0, max = 100000)
    private String id;

    @Size(min = 3, max = 100, message = "El nombre no puede ser menor de 3 caracteres y mayor de 100")
    private String name;

    @Min(value = 0, message = "El promedio no puede ser menor a 0")
    @Max(value = 10, message = "El promedio no puede ser mayor a 10")
    private Double promedio;
}
