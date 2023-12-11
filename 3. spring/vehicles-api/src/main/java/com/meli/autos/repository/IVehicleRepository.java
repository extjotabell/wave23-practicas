package com.meli.autos.repository;

import com.meli.autos.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {

    List<Vehicle> getAll();

    Vehicle addVehicle(Vehicle vehicle);
}
