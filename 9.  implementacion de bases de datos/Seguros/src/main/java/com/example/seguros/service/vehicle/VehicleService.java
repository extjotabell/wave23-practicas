package com.example.seguros.service.vehicle;

import com.example.seguros.dto.VehicleRequestDTO;
import com.example.seguros.dto.VehicleResponseDTO;
import com.example.seguros.model.Vehicle;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleService {
    void postVehicle(VehicleRequestDTO vehicleRequestDTO);

    List<VehicleResponseDTO> findAll();

    List<String> findAllPatents();

    List<Object[]> findAllPatentsAndBrand();

    List<VehicleResponseDTO> findAllByCurrentYear();

    List<VehicleResponseDTO> findAllByCostGreaterThan(Double cost);

}
