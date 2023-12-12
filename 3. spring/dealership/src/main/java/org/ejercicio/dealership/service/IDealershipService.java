package org.ejercicio.dealership.service;

import org.ejercicio.dealership.dto.VehicleDto;
import org.ejercicio.dealership.entity.Vehicle;
import org.ejercicio.dealership.exception.InvalidDatesException;
import org.ejercicio.dealership.exception.InvalidPricesException;
import org.ejercicio.dealership.exception.NotFindVehicleByRegistrationException;

import java.util.List;

public interface IDealershipService {

    VehicleDto addVehicule(Vehicle vehicle) throws VehicleAlreadyExistingException;

    List<VehicleDto> getAllVehicles();

    List<VehicleDto> findVehiclesAccordingToDate(String since, String to) throws InvalidDatesException;

    List<VehicleDto> findVehiclesAccordingToPrice(String since, String to) throws InvalidPricesException;

    VehicleDto findVehicleByRegistration(String registration) throws NotFindVehicleByRegistrationException;
}
