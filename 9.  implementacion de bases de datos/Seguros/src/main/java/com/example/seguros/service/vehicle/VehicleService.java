package com.example.seguros.service.vehicle;

import com.example.seguros.dto.VehicleRequestDTO;
import com.example.seguros.dto.VehicleResponseDTO;

import java.util.List;

public interface VehicleService {
    void postVehicle(VehicleRequestDTO vehicleRequestDTO);

    List<VehicleResponseDTO> findAll();
}
