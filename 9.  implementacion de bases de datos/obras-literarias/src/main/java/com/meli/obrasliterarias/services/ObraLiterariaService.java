package com.meli.obrasliterarias.services;


import com.meli.obrasliterarias.dtos.ObraLiterariaDTO;
import com.meli.obrasliterarias.entities.ObraLiteraria;
import com.meli.obrasliterarias.mappers.ObraLiterariaMapper;
import com.meli.obrasliterarias.repositories.IObrasLiterariasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ObraLiterariaService {

    private IObrasLiterariasRepository obrasLiterariasRepository;

    public ObraLiterariaService(IObrasLiterariasRepository obrasLiterariasRepository) {
        this.obrasLiterariasRepository = obrasLiterariasRepository;
    }

    public ObraLiterariaDTO save(ObraLiterariaDTO obraLiteraria) {
        return ObraLiterariaMapper.toDTO(obrasLiterariasRepository.save(ObraLiterariaMapper.toEntity(obraLiteraria)));
    }

    public List<ObraLiterariaDTO> findByAutor(String autor) {
        return obrasLiterariasRepository.findByAutor(autor).stream().map(ObraLiterariaMapper::toDTO).toList();
    }

    public List<ObraLiterariaDTO> findByMorePagesThan(Integer pages) {
        return obrasLiterariasRepository.findByCantidadDePaginasGreaterThan(pages).stream().map(ObraLiterariaMapper::toDTO).toList();
    }

    public List<ObraLiterariaDTO> getAll() {
        Iterable<ObraLiteraria> obraLiterariasIterator= obrasLiterariasRepository.findAll();
        return StreamSupport.stream(obraLiterariasIterator.spliterator(), false).toList()
                                                .stream().map(ObraLiterariaMapper::toDTO).toList();
    }

    public List<ObraLiterariaDTO> getAllDateBefore(String year) {
        return obrasLiterariasRepository.findByPrimeraPublicacionBefore(year).stream().map(ObraLiterariaMapper::toDTO).toList();
    }
}
