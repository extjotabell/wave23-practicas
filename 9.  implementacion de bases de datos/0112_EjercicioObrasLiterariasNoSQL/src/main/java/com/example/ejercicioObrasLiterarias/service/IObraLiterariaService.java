package com.example.ejercicioObrasLiterarias.service;

import com.example.ejercicioObrasLiterarias.dto.MessageDto;
import com.example.ejercicioObrasLiterarias.dto.ObraLiterariaDto;

import java.util.List;

public interface IObraLiterariaService {

    MessageDto save(ObraLiterariaDto obraLiterariaDto);
    List<ObraLiterariaDto> findAll();


}
