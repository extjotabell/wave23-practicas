package com.meli.Vehiculos.service;

import com.meli.Vehiculos.dto.response.SiniestroResponseDTO;
import com.meli.Vehiculos.dto.request.SiniestroRequestDTO;

import java.util.List;

public interface ISiniestroService {

    List<SiniestroResponseDTO> findAll();
    SiniestroResponseDTO findById(Long id);
    SiniestroResponseDTO save(SiniestroRequestDTO siniestroDTO);

}
