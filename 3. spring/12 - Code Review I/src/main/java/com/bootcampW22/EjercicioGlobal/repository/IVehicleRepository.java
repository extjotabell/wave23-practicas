package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.Collection;
import java.util.List;
import java.util.OptionalDouble;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    Vehicle findById(Long id);
    boolean addVehicle(Vehicle vehicle);
    List<Vehicle> findByColorAndYear(String color, int year);
    List<Vehicle> findByBrandAndYears (String brand, int start_year, int end_year);
    OptionalDouble getSpeedAverageByBrand(String brand);

    void updateSpeed(Long id, String max_speed);

    List<Vehicle> getVehiclesByDimensions(double minLenght, double maxLenght, double minWidth, double maxWidth);

    OptionalDouble getCapacityAverageByBrand(String brand);

    void updateFuel(Long id, String message);

    List<Vehicle> getVehiclesByWeight(double min, double max);

    void deleteVehicle(Long id);

    List<Vehicle> getByFuelType(String type);

    List<Vehicle> getByTransmissionType(String type);
}
