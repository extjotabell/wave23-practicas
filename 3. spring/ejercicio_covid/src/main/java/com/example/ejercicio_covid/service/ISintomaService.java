package com.example.ejercicio_covid.service;

import com.example.ejercicio_covid.dto.SintomaDto;

import java.util.List;

public interface ISintomaService {
    List<SintomaDto> getAllSintomas();

    List<SintomaDto> getSintom(String variable);
}
