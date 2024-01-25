package com.example.covid.service;

import com.example.covid.dto.SintomaDto;
import com.example.covid.entity.Sintoma;
import com.example.covid.repository.SintomaRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class SintomaServiceImpl implements ISintomaService{

    final SintomaRepositoryImpl repository;

    public SintomaServiceImpl(SintomaRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public List<SintomaDto> getAllSintomas() {
        List<SintomaDto> respuesta = new ArrayList<>();

        List<Sintoma> SintomaList = repository.findAll();

        for (Sintoma sintoma: SintomaList
        ) {
            respuesta.add(new SintomaDto(sintoma.getCode(),
                    sintoma.getName(),
                    sintoma.getSeveridad()));
        }
        return respuesta;
    }

    @Override
    public List<SintomaDto> getSintom(String variable) {
        List<SintomaDto> respuesta = new ArrayList<>();

        List<Sintoma> SintomaList = repository.findAll().stream().filter(sintoma -> sintoma.getName().equals(variable)).toList();

        for (Sintoma sintoma: SintomaList
             ) {
            respuesta.add(new SintomaDto(
                    sintoma.getCode(),
                    sintoma.getName(),
                    sintoma.getSeveridad()));
        }
        return respuesta;
    }
}
