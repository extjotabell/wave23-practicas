package com.meli.concesionaria.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.concesionaria.dto.VehicleDTO;
import com.meli.concesionaria.entity.Vehicle;
import com.meli.concesionaria.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository repo;
    @Autowired
    private ObjectMapper objectMapper;

    public VehicleDTO save(VehicleDTO vehicleDTO) {
        Vehicle vehicle = objectMapper.convertValue(vehicleDTO,Vehicle.class);
        Vehicle result = repo.save(Objects.requireNonNull(vehicle));
        return objectMapper.convertValue(result,VehicleDTO.class);
    }
    public List<VehicleDTO> getAllVehicles() {
        List<Vehicle> vehicleList = repo.getAll();
        List<VehicleDTO> vehicleDTOList = new ArrayList<>();

        vehicleList.stream().forEach(vehicle-> {
            vehicleDTOList.add(objectMapper.convertValue(vehicle,VehicleDTO.class));
        });

        return vehicleDTOList;
    }

    public List<VehicleDTO> getAllByDates(String since, String to) {
        List<Vehicle> vehicleList = repo.getAllByDates(since,to);
        List<VehicleDTO> vehicleDTOList = new ArrayList<>();

        vehicleList.stream().forEach(vehicle -> {
            vehicleDTOList.add(objectMapper.convertValue(vehicle,VehicleDTO.class));
        });

        return vehicleDTOList;
    }

    public List<VehicleDTO> getAllByPrice(Double since, Double to) {
        List<Vehicle> vehicleList = repo.getAllByPrice(since,to);
        List<VehicleDTO> vehicleDTOList = new ArrayList<>();

        vehicleList.stream().forEach(vehicle -> {
            vehicleDTOList.add(objectMapper.convertValue(vehicle,VehicleDTO.class));
        });

        return vehicleDTOList;
    }

    public VehicleDTO getById(long id) {
        Vehicle vehicle = repo.getById(id);
        VehicleDTO vehicleDTO = objectMapper.convertValue(vehicle,VehicleDTO.class);
        return vehicleDTO;
    }
}
