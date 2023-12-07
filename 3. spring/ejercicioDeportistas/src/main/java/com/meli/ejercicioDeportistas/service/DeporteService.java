package com.meli.ejercicioDeportistas.service;

import com.meli.ejercicioDeportistas.model.dto.DeporteListResponseDTO;
import com.meli.ejercicioDeportistas.model.Deporte;
import com.meli.ejercicioDeportistas.repository.DeporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeporteService {
    @Autowired
    private DeporteRepository repo;
    public DeporteListResponseDTO getAllDeportes(){
        List<Deporte> deportes = repo.getAllDeportes();
        return new DeporteListResponseDTO(
                deportes.stream().map(Deporte::toResponseDTO).toList()
        );
    }
    public DeporteListResponseDTO getDeporteByName(String name){
        List<Deporte> deportes = repo.getAllDeportes();
        return new DeporteListResponseDTO(
                deportes.stream()
                        .filter(deporte -> name.equals(deporte.getNombre()))
                        .map(Deporte::toResponseDTO)
                        .toList()
        );
    }
}
