package com.example.ejercicioObrasLiterarias.service.impl;

import com.example.ejercicioObrasLiterarias.dto.MessageDto;
import com.example.ejercicioObrasLiterarias.dto.ObraLiterariaDto;
import com.example.ejercicioObrasLiterarias.model.ObraLiteraria;
import com.example.ejercicioObrasLiterarias.repository.ObraLiterariaRepository;
import com.example.ejercicioObrasLiterarias.service.IObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ObraLiterariaServiceImpl implements IObraLiterariaService {

    @Autowired
    private ObraLiterariaRepository obraLiterariaRepository;

    @Override
    public MessageDto save(ObraLiterariaDto obraLiterariaDto) {
        obraLiterariaRepository.save(new ObraLiteraria(
                obraLiterariaDto.getId(),
                obraLiterariaDto.getNombre(),
                obraLiterariaDto.getAutor(),
                obraLiterariaDto.getPaginas(),
                obraLiterariaDto.getEditorial(),
                obraLiterariaDto.getAnioPublicacion()
        ));
        return new MessageDto("Ok");
    }

    @Override
    public List<ObraLiterariaDto> findAll() {
        List<ObraLiteraria> obraLiterariaList = StreamSupport.stream(
                        obraLiterariaRepository.findAll().spliterator(), false)
                .toList();

        return obraLiterariaList.stream()
                .map(o -> new ObraLiterariaDto(
                        o.getId(),
                        o.getNombre(),
                        o.getAutor(),
                        o.getPaginas(),
                        o.getEditorial(),
                        o.getAnioPublicacion()
                )).toList();
    }
}
