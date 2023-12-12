package com.example.calculadoraCalorias.service;


import com.example.calculadoraCalorias.dto.response.CaloriasDto;
import com.example.calculadoraCalorias.dto.response.IngredienteDto;
import com.example.calculadoraCalorias.entity.Ingrediente;
import com.example.calculadoraCalorias.entity.IngredientesCantidad;
import com.example.calculadoraCalorias.repository.CaloriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaloriasService implements ICaloriaService{

    @Autowired
    CaloriasRepository repository;

    @Override
    public List<CaloriasDto> getCalorias(String plato) {

        List<IngredientesCantidad> ingredientesPlato = new ArrayList<>();

        List<CaloriasDto> listCaloriaDto = new ArrayList<>();

        repository.getPlatos().forEach(p -> ingredientesPlato.addAll(p.getIngredientes()));

        CaloriasDto dto = new CaloriasDto();

        ingredientesPlato.forEach(i -> {


            Ingrediente ingrediente = repository.getIngrediente(i.getNombre());
            dto.setTotalCalorias(ingrediente.getCalories() * i.getCantidad());
            dto.setIngredientes(new IngredienteDto(i.getNombre(),ingrediente.getCalories()));
            if(dto.getIngredienteCaloriaMax() == null){
                dto.setIngredienteCaloriaMax(i.getNombre());
            }else if(ingrediente.getCalories() > repository.getIngrediente(dto.getIngredienteCaloriaMax()).getCalories()){
                dto.setIngredienteCaloriaMax(i.getNombre());
            }


        });

        listCaloriaDto.add(dto);

        return listCaloriaDto;
    }
}
