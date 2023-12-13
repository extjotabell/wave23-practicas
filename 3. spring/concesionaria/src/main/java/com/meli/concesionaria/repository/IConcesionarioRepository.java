package com.meli.concesionaria.repository;

import com.meli.concesionaria.entity.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface IConcesionarioRepository {

    Vehicle create(Vehicle vehicle);

    List<Vehicle> getAll();

    Vehicle getById(Integer id);

    List<Vehicle> getByDate(LocalDate since, LocalDate to);

    List<Vehicle> getByPrice(Double since, Double to);

}
