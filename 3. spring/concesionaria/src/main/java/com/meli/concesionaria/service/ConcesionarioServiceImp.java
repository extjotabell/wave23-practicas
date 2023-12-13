package com.meli.concesionaria.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.concesionaria.dto.VehicleDto;
import com.meli.concesionaria.entity.Vehicle;
import com.meli.concesionaria.repository.IConcesionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ConcesionarioServiceImp implements IConcesionarioService {

    @Autowired
    private IConcesionarioRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public VehicleDto create(VehicleDto vehicle) {
        Vehicle vehicleEntity = objectMapper.convertValue(vehicle, Vehicle.class);
        Vehicle vehicleResponse = repository.create(vehicleEntity);
        return objectMapper.convertValue(vehicleResponse, VehicleDto.class);
    }

    @Override
    public List<VehicleDto> getAll() {
        List<Vehicle> vehicles = repository.getAll();
        return objectMapper.convertValue(vehicles, new TypeReference<>() {});
    }

    @Override
    public VehicleDto getById(Integer id) {
        Vehicle vehicle = repository.getById(id);
        return objectMapper.convertValue(vehicle, VehicleDto.class);
    }

    @Override
    public List<VehicleDto> getByDate(LocalDate since, LocalDate to) {
        List<Vehicle> vehicles = repository.getByDate(since, to);
        return objectMapper.convertValue(vehicles, new TypeReference<>() {});
    }

    @Override
    public List<VehicleDto> getByPrice(Double since, Double to) {
        List<Vehicle> vehicles = repository.getByPrice(since, to);
        return objectMapper.convertValue(vehicles, new TypeReference<>() {});
    }
}
