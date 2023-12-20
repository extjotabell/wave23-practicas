package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    Optional<Vehicle> find(Long id);
    void create(Vehicle vehicle);
    List<Vehicle> findByColorAndYear(String color, int year);
    List<Vehicle> findByBrandAndYearRange(String brand, int startYear, int endYear);
    Double getAverageSpeedByBrand(String brand);
    boolean anyMatchBrand(String brand);
    void createBatch(List<Vehicle> vehicles);
    void updateMaxSpeed(Long id, String maxSpeed);
    List<Vehicle> findByFuelType(String fuelType);
    boolean anyMatchFuelType(String fuelType);
    void delete(Long id);
    boolean anyMatchTransmission(String transmission);
    List<Vehicle> findByTransmission(String transmission);
    void updateFuelType(Long id, String fuelType);
    Double getAverageCapacityByBrand(String brand);
    List<Vehicle> findByDimensions(double minHeight, double maxHeight, double minWidth, double maxWidth);
    List<Vehicle> findByWeightRange(double minWeight, double maxWeight);
}
