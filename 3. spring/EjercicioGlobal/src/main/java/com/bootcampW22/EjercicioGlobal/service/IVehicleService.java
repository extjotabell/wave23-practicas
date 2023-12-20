package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    void create(VehicleDto vehicleDto);
    List<VehicleDto> findByColorAndYear(String color, int year);
    List<VehicleDto> findByBrandAndYearRange(String brand, int startYear, int endYear);
    Double getAverageSpeedByBrand(String brand);
    void createBatch(List<VehicleDto> vehicles);
    void updateMaxSpeed(Long id, String maxSpeed);
    List<VehicleDto> findByFuelType(String fuelType);
    void delete(Long id);
    List<VehicleDto> findByTransmission(String transmission);
    void updateFuelType(Long id, String fuelType);
    Double getAverageCapacityByBrand(String brand);
    List<VehicleDto> findByDimensions(String heightRange, String widthRange);
    List<VehicleDto> findByWeightRange(double minWeight, double maxWeight);

}
