package com.example.concesionariaautos.service;

import com.example.concesionariaautos.dto.VehicleDTO;
import com.example.concesionariaautos.entity.Vehicle;

import java.util.Date;
import java.util.List;

public interface VehicleService {
    void addVehicle(Vehicle vehicle);
    List<VehicleDTO> getVehicles();
    List<VehicleDTO> getVehiclesByDate(Date since, Date to);
    List<VehicleDTO> getVehiclesByPrice(Double since, Double to);
    VehicleDTO getVehicleById(int id);


}
