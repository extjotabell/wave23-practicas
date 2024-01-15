package com.meli.ejercicioSiniestros.service;

import com.meli.ejercicioSiniestros.dto.SiniestroFullDTO;
import com.meli.ejercicioSiniestros.dto.request.SiniestroCreationDTO;
import com.meli.ejercicioSiniestros.model.Siniestro;
import com.meli.ejercicioSiniestros.repository.ISiniestroRepository;
import com.meli.ejercicioSiniestros.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiniestroService {

    private final ISiniestroRepository repository;

    public SiniestroService(ISiniestroRepository repository) {
        this.repository = repository;
    }

    public SiniestroFullDTO createSiniestro(SiniestroCreationDTO siniestroDto){
        Siniestro siniestro = Mapper.mapSiniestroCreationToSiniestro(siniestroDto);
        Siniestro result = repository.save(siniestro);
        return Mapper.mapSiniestroToSiniestroFull(result);
    }

    public List<SiniestroFullDTO> getAllSiniestros(){
        List<Siniestro> siniestros = repository.findAll();
        return siniestros.stream().map(Mapper::mapSiniestroToSiniestroFull).toList();
    }
}
