package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.IngredienteDTO;
import com.example.calculadoracalorias.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredienteService {
    @Autowired
    private IngredienteRepository repository;

    public IngredienteDTO findIngredienteByName(String name) throws Exception {
        IngredienteDTO ingrediente = repository.findIngredienteByName(name);
        if (ingrediente==null){
            throw new Exception("No existe el ingrediente llamado: " + name);
        }
        return ingrediente;
    }
}
