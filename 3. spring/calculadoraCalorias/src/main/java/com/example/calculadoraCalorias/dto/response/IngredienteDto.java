package com.example.calculadoraCalorias.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IngredienteDto {

    private String nombre;
    private int calorias;
}
