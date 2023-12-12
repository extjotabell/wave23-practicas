package com.meli.concesionaria.repository;

import com.meli.concesionaria.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class VehicleRepository {
    List<Vehicle> vehicleList = new ArrayList<>();
    public Vehicle save(Vehicle vehicle) {
        vehicleList.add(vehicle);
        return vehicle;
    }

    public List<Vehicle> getAll() {
        return vehicleList;
    }

    public List<Vehicle> getAllByDates(String since, String to) {
        LocalDate sinceDate = LocalDate.parse(since);
        LocalDate toDate = LocalDate.parse(to);

        List<Vehicle> result = vehicleList.stream()
                .filter(vehicle -> {
                    LocalDate manufacturingDate = LocalDate.parse(vehicle.getManufacturingDate());
                    return manufacturingDate.isAfter(sinceDate) && manufacturingDate.isBefore(toDate);
                })
                .collect(Collectors.toList());

        return result;
    }

    public List<Vehicle> getAllByPrice(Double since, Double to) {

        List<Vehicle> result = vehicleList.stream()
                .filter(vehicle -> {
                    double price = vehicle.getPrice();
                    return Double.compare(price, since) >= 0 && Double.compare(price, to) <= 0;
                })
                .collect(Collectors.toList());

        return result;
    }

    public Vehicle getById(long id) {
        Vehicle vehicle = vehicleList.stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .orElse(null);
        return vehicle;
    }
}
