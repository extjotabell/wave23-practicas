package com.meli.Vehiculos.service;

import com.meli.Vehiculos.dto.response.SiniestroResponseDTO;
import com.meli.Vehiculos.dto.request.SiniestroRequestDTO;
import com.meli.Vehiculos.exception.NotFoundException;
import com.meli.Vehiculos.model.Siniestro;
import com.meli.Vehiculos.model.Vehiculo;
import com.meli.Vehiculos.repository.ISiniestroRepository;
import com.meli.Vehiculos.repository.IVehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiniestroService implements ISiniestroService {

    ISiniestroRepository siniestroRepository;
    IVehiculoRepository vehiculoRepository;

    public SiniestroService(ISiniestroRepository siniestroRepository, IVehiculoRepository vehiculoRepository) {
        this.siniestroRepository = siniestroRepository;
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public List<SiniestroResponseDTO> findAll() {
        List<Siniestro> siniestros = siniestroRepository.findAll();
        return siniestros.stream().map(SiniestroResponseDTO::new).toList();
    }

    @Override
    public SiniestroResponseDTO findById(Long id) {
        Siniestro siniestro = siniestroRepository.findById(id).orElseThrow(() -> new NotFoundException("Siniestro no encontrado"));
        return new SiniestroResponseDTO(siniestro);
    }

    @Override
    public SiniestroResponseDTO save(SiniestroRequestDTO siniestroDTO) {
        // Check if vehiculo exists
        Vehiculo vehiculo = vehiculoRepository.findById(siniestroDTO.getVehiculoId()).orElseThrow(() -> new NotFoundException("Vehiculo no encontrado"));

        Siniestro siniestroToSave = new Siniestro(siniestroDTO, vehiculo);
        Siniestro siniestroSaved = siniestroRepository.save(siniestroToSave);
        return new SiniestroResponseDTO(siniestroSaved);
    }
}
