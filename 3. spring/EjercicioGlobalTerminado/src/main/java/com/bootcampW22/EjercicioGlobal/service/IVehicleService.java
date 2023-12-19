package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    VehicleDto addVehicle(VehicleDto vehicleDto);
    VehicleDto searchVehicle(Long id);
    List<VehicleDto> searchVehiclesColorYear(String color, int year);
    List<VehicleDto> searchVehicleBrandBetweenYears(String brand, int start_year, int end_year);
    Double averageSpeedBrand(String brand);
    List<VehicleDto> saveVehicles(List<VehicleDto> listVehicles);
    Boolean updateSpeed (int id, int speed);
    List<VehicleDto> fuelType(String fuelType);
    Boolean deleteVehicle(int id);
    List<VehicleDto> transmissionType(String transmissionType);
    Boolean updateFuel(int id, String fuel);
    Double averageCapacityBrand(String brand);
    List<VehicleDto> searchVehicleBrandBetweenYears(Double min_length, Double max_length, Double min_width, Double max_width);
}
