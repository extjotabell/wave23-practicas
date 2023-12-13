package com.example.ejercicio_deporte.service;

import com.example.ejercicio_deporte.dto.DeporteDto;
import com.example.ejercicio_deporte.entity.Deporte;
import com.example.ejercicio_deporte.repository.DeporteRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeporteServiceImpl implements IDeporteService{

    @Autowired
    DeporteRepositoryImpl repository;

    @Override
    public List<DeporteDto> getAllDeporte() {
        List<DeporteDto> respuesta = new ArrayList<>();

        List<Deporte> listaFiltrada = repository.findAll();

        for (Deporte aux: listaFiltrada
             ) {
            respuesta.add(new DeporteDto(aux.getName(),
                    aux.getLvl(),
                    aux.getParticipantes()));
        }
        return respuesta;
    }

    @Override
    public List<DeporteDto> getDeporte(String variable) {
        List<DeporteDto> respuesta = new ArrayList<>();

        List<Deporte> listaFiltrada = repository.findAll();

        listaFiltrada = listaFiltrada.stream().filter(deporte -> deporte.getName().equals(variable)).toList();

        for (Deporte aux: listaFiltrada
        ) {
            respuesta.add(new DeporteDto(aux.getName(),
                    aux.getLvl(),
                    aux.getParticipantes()));
        }
        return respuesta;
    }
}
