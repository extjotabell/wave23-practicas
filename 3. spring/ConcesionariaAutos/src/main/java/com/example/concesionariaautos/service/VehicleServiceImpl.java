package com.example.concesionariaautos.service;


import com.example.concesionariaautos.dto.VehicleDTO;
import com.example.concesionariaautos.entity.Vehicle;
import com.example.concesionariaautos.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehicleRepository.addVehicle(vehicle);
    }

    @Override
    public List<VehicleDTO> getVehicles() {
        return vehicleRepository.getVehicles().stream().map(Vehicle::mapToDTO).toList();
    }

    @Override
    public List<VehicleDTO> getVehiclesByDate(Date since, Date to) {
        return vehicleRepository.getVehicles()
                                .stream()
                                .filter(vehicle -> vehicle.getManufacturingDate().before(to) &&
                                                   vehicle.getManufacturingDate().after(since))
                                .map(Vehicle::mapToDTO)
                                .toList();
    }

    @Override
    public List<VehicleDTO> getVehiclesByPrice(Double since, Double to) {
        return vehicleRepository.getVehicles()
                                .stream()
                                .filter(vehicle -> vehicle.getPrice() >= since && vehicle.getPrice() <= to)
                                .map(Vehicle::mapToDTO)
                                .toList();
    }

    @Override
    public VehicleDTO getVehicleById(int id) {
        return vehicleRepository.findVehicleById(id).mapToDTO();
    }
}
