package org.ejercicio.dealership.repository;


import org.ejercicio.dealership.entity.Vehicle;

import java.util.List;

public interface IDealershipRepository {

    void addVehicule(Vehicle vehicle);

    List<Vehicle> getAllVehicles();

    List<Vehicle> findVehiclesAccordingToDate(String since, String to);

    List<Vehicle> findVehiclesAccordingToPrice(String since, String to);

    Vehicle findVehicleByRegistration(String registration);
}
