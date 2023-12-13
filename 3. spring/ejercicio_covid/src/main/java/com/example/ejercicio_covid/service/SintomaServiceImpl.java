package com.example.ejercicio_covid.service;

import com.example.ejercicio_covid.dto.SintomaDto;
import com.example.ejercicio_covid.entitie.Sintoma;
import com.example.ejercicio_covid.repository.SintomaRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class SintomaServiceImpl implements ISintomaService{

    @Autowired
    SintomaRepositoryImpl repository;

    @Override
    public List<SintomaDto> getAllSintomas() {
        List<SintomaDto> respuesta = new ArrayList<>();

        List<Sintoma> SintomaList = repository.findAll();

        for (Sintoma aux: SintomaList
        ) {
            respuesta.add(new SintomaDto(aux.getCode(),
                    aux.getName(),
                    aux.getLvl()));
        }
        return respuesta;
    }

    @Override
    public List<SintomaDto> getSintom(String variable) {
        List<SintomaDto> respuesta = new ArrayList<>();

        List<Sintoma> SintomaList = repository.findAll().stream().filter(sintoma -> sintoma.getName().equals(variable)).toList();

        for (Sintoma aux: SintomaList
             ) {
            respuesta.add(new SintomaDto(
                    aux.getCode(),
                    aux.getName(),
                    aux.getLvl()
            ));
        }
        return respuesta;
    }
}
