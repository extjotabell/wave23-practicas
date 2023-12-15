package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    VehicleDto saveVehicle(VehicleDto vehicleDto);

    List<VehicleDto> getAllByColorAndYear(String color, int year);

    List<VehicleDto> getAllByBrandAndYear(String brand, int start_year, int end_year);

    double getMaxSpeedAverageByBrand(String brand);
    Boolean validarId(long id);

    VehicleDto updateSpeed(long id, double speed);

    List<VehicleDto> getAllByFuelType(String type);

    Boolean delete(long id);

    int getCapacityByBrand(String brand);

    List<VehicleDto> getByDimensions(double length, double width);

    List<VehicleDto> getByTransmission(String type);

    VehicleDto updateFuel(long id, String fuel);

    List<VehicleDto> getAllByWeight(double weight_min, double weight_max);

    List<VehicleDto> saveAll(List<VehicleDto> vehicleDtoList);
}
