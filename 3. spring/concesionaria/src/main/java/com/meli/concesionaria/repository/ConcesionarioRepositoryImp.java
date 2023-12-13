package com.meli.concesionaria.repository;

import com.meli.concesionaria.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ConcesionarioRepositoryImp implements IConcesionarioRepository {

    private final List<Vehicle> vehicles;

    public ConcesionarioRepositoryImp() {
        vehicles = new ArrayList<>();
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        vehicles.add(vehicle);
        return vehicle;
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicles;
    }

    @Override
    public Vehicle getById(Integer id) {
        return vehicles.stream()
            .filter(v -> v.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    @Override
    public List<Vehicle> getByDate(LocalDate since, LocalDate to) {
        return vehicles.stream()
            .filter(v -> v.getManufacturingDate().isAfter(since) && v.getManufacturingDate().isBefore(to))
            .toList();
    }

    @Override
    public List<Vehicle> getByPrice(Double since, Double to) {
        return vehicles.stream()
            .filter(v -> v.getPrice() >= since && v.getPrice() <= to)
            .toList();
    }
}
