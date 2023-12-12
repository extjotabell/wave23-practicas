package com.example.calculadoraCalorias.dto.response;

import com.example.calculadoraCalorias.entity.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Getter
public class CaloriasDto {

    private int totalCalorias;

    private List<IngredienteDto> ingredientes;

    private String ingredienteCaloriaMax;

    public CaloriasDto() {
        this.ingredientes = new ArrayList<>();
    }

    public void setTotalCalorias(int totalCalorias) {
        this.totalCalorias = this.totalCalorias + totalCalorias;
    }

    public void setIngredientes(IngredienteDto ing){
        ingredientes.add(ing);
    }

    public void setIngredienteCaloriaMax(String ing){
        this.ingredienteCaloriaMax = ing;
    }
}
