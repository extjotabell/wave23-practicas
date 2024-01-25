package com.example.covid.service;

import com.example.covid.dto.SintomaDto;

import java.util.List;

public interface ISintomaService {
    List<SintomaDto> getAllSintomas();

    List<SintomaDto> getSintom(String variable);
}
