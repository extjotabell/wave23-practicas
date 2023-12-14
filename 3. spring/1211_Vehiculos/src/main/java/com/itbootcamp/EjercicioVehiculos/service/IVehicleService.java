package com.itbootcamp.EjercicioVehiculos.service;

import com.itbootcamp.EjercicioVehiculos.dto.MessageDto;
import com.itbootcamp.EjercicioVehiculos.dto.VehicleDto;
import com.itbootcamp.EjercicioVehiculos.dto.request.VehicleRequestDto;
import com.itbootcamp.EjercicioVehiculos.dto.response.VehicleWithoutServicesResponseDto;
import com.itbootcamp.EjercicioVehiculos.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    MessageDto save(VehicleRequestDto vehicleRequestDto);
    List<VehicleWithoutServicesResponseDto> findAll();
    VehicleDto findById(int id);
    List<VehicleWithoutServicesResponseDto> findDatesRange(String since, String to);
    List<VehicleWithoutServicesResponseDto> findByPriceRange(int since, int to);
}
