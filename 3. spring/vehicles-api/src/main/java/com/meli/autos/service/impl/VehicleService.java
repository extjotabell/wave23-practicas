package com.meli.autos.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.autos.dto.request.VehicleEntryDTO;
import com.meli.autos.dto.response.VehicleDTO;
import com.meli.autos.entity.Vehicle;
import com.meli.autos.mapper.VehicleMapper;
import com.meli.autos.repository.IVehicleRepository;
import com.meli.autos.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private IVehicleRepository vehicleRepository;

    @Override
    public List<VehicleDTO> getAll() {
        ObjectMapper mapper = new ObjectMapper();
        return vehicleRepository.getAll().stream().map(VehicleMapper::vehicleToVehicleDTO).toList();
    }

    @Override
    public VehicleDTO addVehicle(VehicleEntryDTO vehicleDTO) {
        Vehicle vehicle = vehicleRepository.addVehicle(VehicleMapper.vehicleDTOToVehicle(vehicleDTO));
        return VehicleMapper.vehicleToVehicleDTO(vehicle);
    }

    @Override
    public Optional<VehicleDTO> getById(long id) {
        return vehicleRepository.getAll().stream()
                                         .filter(v-> v.getId() == id).findFirst()
                                         .map(VehicleMapper::vehicleToVehicleDTO);
    }

    @Override
    public List<VehicleDTO> getAllByDateRange(String since, String to) {

        LocalDate init = LocalDate.parse(since);

        LocalDate end = LocalDate.parse(to);
        return vehicleRepository.getAll().stream()
                                         .filter(v -> !v.getManufacturingDate().isBefore(init) && !v.getManufacturingDate().isAfter(end))
                                         .map(VehicleMapper::vehicleToVehicleDTO)
                                         .toList();
    }

    @Override
    public List<VehicleDTO> getAllByPriceRange(String since, String to) {
        return vehicleRepository.getAll().stream()
                .filter(v -> v.getPrice() >= Double.parseDouble(since) && v.getPrice() <= Double.parseDouble(to))
                .map(VehicleMapper::vehicleToVehicleDTO)
                .toList();
    }
}
