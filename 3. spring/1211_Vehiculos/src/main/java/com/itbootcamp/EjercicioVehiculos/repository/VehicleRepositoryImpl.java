package com.itbootcamp.EjercicioVehiculos.repository;

import com.itbootcamp.EjercicioVehiculos.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    List<Vehicle> vehicleList = new ArrayList<>();

    @Override
    public void save(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleList;
    }

    @Override
    public Vehicle findById(int id) {
        return vehicleList.stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
