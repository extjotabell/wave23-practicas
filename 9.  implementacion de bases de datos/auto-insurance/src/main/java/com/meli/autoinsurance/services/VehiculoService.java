package com.meli.autoinsurance.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.autoinsurance.dtos.VehiculoDTO;
import com.meli.autoinsurance.entities.Vehiculo;
import com.meli.autoinsurance.repositories.IVehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {

    private final IVehiculoRepository vehiculoRepository;

    public VehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public VehiculoDTO getVehiculoById(Long id) {
        ObjectMapper mapper = new ObjectMapper();
        Vehiculo vehiculo = vehiculoRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehiculo not found for this id  : " + id));
        return mapper.convertValue(vehiculo, VehiculoDTO.class);
    }

    public List<String> getPatentes() {
        return vehiculoRepository.getPatentes();
    }
}
