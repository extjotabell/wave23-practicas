package com.itbootcamp.EjercicioVehiculos.repository;

import com.itbootcamp.EjercicioVehiculos.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    void save(Vehicle vehicle);
    List<Vehicle> findAll();
    Vehicle findById(int id);
}
