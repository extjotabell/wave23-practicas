package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    VehicleDto save(VehicleDto vehicleDto);

    List<VehicleDto> filterByColorAndYear(String color, int year);

    List<VehicleDto> filterByBrandAndRangeDate(String brand, int startYear, int endYear);

    Double getAverageSpeedByBrand(String brand);

    List<VehicleDto> save(List<VehicleDto> vehiclesDto);

    VehicleDto updateSpeed(Long id, String newSpeed);

    List<VehicleDto> filterByFuelType(String fuelType);

    void delete(Long id);

    List<VehicleDto> filterByTransmission(String type);

    VehicleDto updateFuel(Long id, String fuel);

    Double getAverageCapacity(String brand);
}
