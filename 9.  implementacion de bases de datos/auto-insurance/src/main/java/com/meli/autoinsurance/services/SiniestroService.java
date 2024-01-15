package com.meli.autoinsurance.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.autoinsurance.dtos.SiniestroDTO;
import com.meli.autoinsurance.entities.Siniestro;
import com.meli.autoinsurance.repositories.ISiniestroRepository;
import org.springframework.stereotype.Service;

@Service
public class SiniestroService {

    private final ISiniestroRepository siniestroRepository;

    public SiniestroService(ISiniestroRepository siniestroRepository) {
        this.siniestroRepository = siniestroRepository;
    }

    public SiniestroDTO getSiniestroById(Long id) {
        ObjectMapper objectMapper = new ObjectMapper();
        Siniestro siniestro = siniestroRepository.findById(id).orElseThrow(() -> new RuntimeException("Siniestro not found for this id: " + id));
        return objectMapper.convertValue(siniestro, SiniestroDTO.class);
    }
}