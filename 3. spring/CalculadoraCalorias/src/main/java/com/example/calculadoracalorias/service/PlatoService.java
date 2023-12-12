package com.example.calculadoracalorias.service;


import com.example.calculadoracalorias.dto.IngredienteDTO;
import com.example.calculadoracalorias.dto.IngredienteItem;
import com.example.calculadoracalorias.dto.IngredienteItemDTO;
import com.example.calculadoracalorias.dto.Plato;
import com.example.calculadoracalorias.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PlatoService {
    @Autowired
    private PlatoRepository platoRepository;
    @Autowired
    private IngredienteService ingredienteService;
    public Plato platoByName(String name){
        return null;
    }

    public double caloriasPlato(String name, double peso) throws Exception {
        Plato p = platoRepository.getPlatoByName(name);
        if(p==null){
            throw new Exception("No existe un plato llamado: " + name);
        }
        double total = 0;
        for(IngredienteItem ingredienteItem:p.getIngredientes()){
            ingredienteItem.setIngrediente(ingredienteService.findIngredienteByName(ingredienteItem.getIngrediente().getName()));
            total+=peso*ingredienteItem.calcularCalorias();
        }
        return total/100;
    }

    public List<IngredienteItemDTO> ingredientesPlato(String name, double peso) throws Exception {
        Plato p = platoRepository.getPlatoByName(name);

        if(p==null){
            throw new Exception("No existe un plato llamado: " + name);
        }
        List<IngredienteItemDTO> ingredientes = new ArrayList<>();
        for(IngredienteItem ingredienteItem:p.getIngredientes()){
            ingredienteItem.setIngrediente(ingredienteService.findIngredienteByName(ingredienteItem.getIngrediente().getName()));
            IngredienteDTO ingrediente = ingredienteItem.getIngrediente();
            double gramos = peso*ingredienteItem.getPorcentajeCantidad()/100;
            ingredientes.add(new IngredienteItemDTO(ingrediente.getName(),gramos,ingrediente.getCalories()*gramos/100));
        }
        return ingredientes;
    }
    public IngredienteItemDTO ingredienteMasCaloricoPlato(String name, double peso) throws Exception {
        Plato p = platoRepository.getPlatoByName(name);
        if(p==null){
            throw new Exception("No existe un plato llamado: " + name);
        }
        List<IngredienteItemDTO> ingredientes = new ArrayList<>();
        for(IngredienteItem ingredienteItem:p.getIngredientes()){
            ingredienteItem.setIngrediente(ingredienteService.findIngredienteByName(ingredienteItem.getIngrediente().getName()));
            IngredienteDTO ingrediente = ingredienteItem.getIngrediente();
            double gramos = peso*ingredienteItem.getPorcentajeCantidad()/100;
            ingredientes.add(new IngredienteItemDTO(ingrediente.getName(),gramos,ingrediente.getCalories()*gramos/100));
        }
        return ingredientes.stream().max(Comparator.comparing(IngredienteItemDTO::getCalorias)).orElseThrow(() -> new Exception("Ocurrio un error"));
    }

}
