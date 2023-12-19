package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    void addVehicle(Vehicle vehicle);
    Vehicle searchVehicle(Long id);
    List<Vehicle> searchVehiclesColorYear(String color, int year);
    List<Vehicle> searchVehicleBrandBetweenYears(String brand, int start_year, int end_year);
    Double averageSpeedBrand(String brand);
    Boolean saveVehicles (List<Vehicle> listVehicles);
    Boolean updateSpeed (int id, int speed);
    List<Vehicle> fuelType(String fuelType);
    Boolean deleteVehicle(int id);
    List<Vehicle> transmissionType(String transmissionType);
    Boolean updateFuel(int id, String fuel);
    Double averageCapacityBrand(String brand);
    List<Vehicle> searchVehicleBrandBetweenYears(Double min_length, Double max_length, Double min_width, Double max_width);
}
