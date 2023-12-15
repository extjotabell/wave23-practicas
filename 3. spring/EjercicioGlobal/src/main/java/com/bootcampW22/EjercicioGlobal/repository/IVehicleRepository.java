package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    Vehicle saveVehicle(Vehicle vehicle);

    List<Vehicle> getAllByColorAndYear(String color, int year);

    List<Vehicle> getAllByBrandAndYear(String brand, int start_year, int end_year);

    double getMaxSpeedAverageByBrand(String brand);

    Vehicle updateSpeed(long id, double speed);

    List<Vehicle> getAllByFuelType(String type);

    Boolean delete(long id);

    int getCapacityByBrand(String brand);

    List<Vehicle> getByDimensions(double length, double width);

    List<Vehicle> getByTransmission(String type);

    Vehicle updateFuel(long id, String fuel);

    List<Vehicle> getAllByWeight(double weight_min, double weight_max);

    List<Vehicle> saveAll(List<Vehicle> vehicleList);

    List<Vehicle> findByBrand(String brand);
}
