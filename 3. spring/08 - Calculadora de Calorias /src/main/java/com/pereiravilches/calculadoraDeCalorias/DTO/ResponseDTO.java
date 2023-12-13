package com.pereiravilches.calculadoraDeCalorias.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    //Cantidad total de calorías del plato
    //Lista de ingredientes que lo conforman y cantidad de calorías de cada uno de ellos
    //El ingrediente con mayor cantidad de calorías
    private int cantTotalCalorias;
    private List<IngredienteDTO> ingredienteDTOList;
    private IngredienteDTO ingrendienteConMasCalorias;

}
