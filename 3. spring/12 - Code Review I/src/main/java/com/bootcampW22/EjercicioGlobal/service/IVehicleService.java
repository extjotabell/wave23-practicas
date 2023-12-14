package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.DatoStringDTO;
import com.bootcampW22.EjercicioGlobal.dto.ResponseDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    ResponseDTO addVehicle(VehicleDto vehicleDto);

    List<VehicleDto> findByColorAndYear(String color, int year);
    List<VehicleDto> findByBrandAndYears (String brand, int start_year, int end_year);
    ResponseDTO getSpeedAverageByBrand (String brand);

    List<ResponseDTO> addVehicles(List<VehicleDto> vehicles);

    ResponseDTO updateSpeed(Long id, DatoStringDTO updateSpeed);

    List<VehicleDto> getVehiclesByDimensions(String lengthRange, String widthRange);

    ResponseDTO getCapacityAverageByBrand(String brand);

    ResponseDTO updateFuel(Long id, DatoStringDTO updateFuel);

    List<VehicleDto> getVehiclesByWeight(double min, double max);

    ResponseDTO deleteVehicle(Long id);

    List<VehicleDto> getByFuelType(String type);

    List<VehicleDto> getByTransmissionType(String type);
}
