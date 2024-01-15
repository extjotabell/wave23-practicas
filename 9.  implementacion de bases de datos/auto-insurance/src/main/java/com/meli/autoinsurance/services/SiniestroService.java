package com.meli.autoinsurance.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.autoinsurance.dtos.response.MatriculaMarcaModeloDTO;
import com.meli.autoinsurance.dtos.request.SiniestroDTO;
import com.meli.autoinsurance.dtos.response.SiniestroResponseDTO;
import com.meli.autoinsurance.entities.Siniestro;
import com.meli.autoinsurance.entities.Vehiculo;
import com.meli.autoinsurance.repositories.ISiniestroRepository;
import com.meli.autoinsurance.repositories.IVehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SiniestroService {

    private final ISiniestroRepository siniestroRepository;
    private final IVehiculoRepository vehiculoRepository;
    private  ObjectMapper objectMapper = new ObjectMapper()
                                             .registerModule(new JavaTimeModule());

    public SiniestroService(ISiniestroRepository siniestroRepository, IVehiculoRepository vehiculoRepository) {
        this.siniestroRepository = siniestroRepository;
        this.vehiculoRepository = vehiculoRepository;
    }

    public SiniestroResponseDTO getSiniestroById(Long id) {
        Siniestro siniestro = siniestroRepository.findById(id).orElseThrow(() -> new RuntimeException("Siniestro not found for this id: " + id));
        return objectMapper.convertValue(siniestro, SiniestroResponseDTO.class);
    }

    public List<MatriculaMarcaModeloDTO> getMatriculaMarcaModeloByPerdidaGreaterThan10K() {
        List<Object []> resultadoRepo = siniestroRepository.getMatriculaMarcaModeloByPerdidaGreaterThan10K();
        List<MatriculaMarcaModeloDTO> resultado = new ArrayList<>();
        for (Object [] r : resultadoRepo) {
            MatriculaMarcaModeloDTO matriculaMarcaModeloDTO = new MatriculaMarcaModeloDTO((String) r[0], (String) r[1], (String) r[2]);
            resultado.add(matriculaMarcaModeloDTO);
        }
        return resultado;
    }

    public SiniestroDTO createSiniestro(SiniestroDTO siniestroDTO) {
        Vehiculo vehiculo = vehiculoRepository.findById(siniestroDTO.getIdVehiculoDenunciado()).orElseThrow(() -> new RuntimeException("Vehiculo not found for this id: " + siniestroDTO.getIdVehiculoDenunciado()));
        Siniestro siniestro = new Siniestro(siniestroDTO.getIdSiniestro(), siniestroDTO.getFechaSiniestro(), siniestroDTO.getPerdidaEconomica(), vehiculo);
        siniestroRepository.save(siniestro);
        return siniestroDTO;
    }
}