package com.example.segurosHQL.service;

import com.example.segurosHQL.model.dto.VehiculoDTO;
import com.example.segurosHQL.model.entity.Vehiculo;
import com.example.segurosHQL.repository.IVehiculoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService{

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    IVehiculoRepository repository;

    @Override
    public List<VehiculoDTO> getVehiculos() {
        List<Vehiculo> vehiculos = repository.getVehiculos();
        return vehiculos.stream()
                .map(vehiculo -> mapper.convertValue(vehiculo, VehiculoDTO.class))
                .toList();
    }

    @Override
    public List<VehiculoDTO> getPatentes() {
        return repository.getVehiculos().stream()
                .map(v -> VehiculoDTO.builder()
                        .patente(v.getPatente())
                        .build())
                .toList();

    }

    @Override
    public List<VehiculoDTO> getPatentesByAnio() {
        List<Vehiculo> vehiculos = repository.getPatentesByAnio();
        return vehiculos.stream()
                .map(vehiculo -> mapper.convertValue(vehiculo, VehiculoDTO.class))
                .toList();
    }

    @Override
    public List<VehiculoDTO> patentesAnioRuedas() {
        List<Vehiculo> vehiculos = repository.patentesAnioRuedas();
        vehiculos.forEach(vehiculo -> System.out.println(vehiculo.toString()));
        return vehiculos.stream()
                .map(vehiculo -> mapper.convertValue(vehiculo, VehiculoDTO.class))
                .toList();
    }


}
