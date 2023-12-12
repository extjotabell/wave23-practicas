package org.ejercicio.dealership.service;

import org.ejercicio.dealership.dto.VehicleDto;
import org.ejercicio.dealership.entity.Vehicle;
import org.ejercicio.dealership.exception.InvalidDatesException;
import org.ejercicio.dealership.exception.InvalidPricesException;
import org.ejercicio.dealership.exception.NotFindVehicleByRegistrationException;
import org.ejercicio.dealership.repository.IDealershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class DealershipServiceImpl implements IDealershipService {

    @Autowired
    IDealershipRepository dealershipRepository;

    @Override
    public VehicleDto addVehicule(Vehicle vehicle) throws VehicleAlreadyExistingException {
        if (this.dealershipRepository.findVehicleByRegistration(vehicle.getRegistration()) != null) {
            throw new VehicleAlreadyExistingException();
        }
        this.dealershipRepository.addVehicule(vehicle);
        return getVehicleDto(vehicle);
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
        List<Vehicle> vehicles = this.dealershipRepository.getAllVehicles();
        return getVehicleDtos(vehicles);
    }

    @Override
    public List<VehicleDto> findVehiclesAccordingToDate(String since, String to) throws InvalidDatesException {
        if (!validDates(since, to)) {
            throw new InvalidDatesException();
        }
        List<Vehicle> vehicles = this.dealershipRepository.findVehiclesAccordingToDate(since, to);
        return getVehicleDtos(vehicles);
    }

    @Override
    public List<VehicleDto> findVehiclesAccordingToPrice(String since, String to) throws InvalidPricesException {
        if (!validPrices(since, to)) {
            throw new InvalidPricesException();
        }
        List<Vehicle> vehicles = this.dealershipRepository.findVehiclesAccordingToPrice(since, to);
        return getVehicleDtos(vehicles);
    }

    @Override
    public VehicleDto findVehicleByRegistration(String registration) throws NotFindVehicleByRegistrationException {
        Vehicle vehicle = this.dealershipRepository.findVehicleByRegistration(registration);
        if (vehicle == null) {
            throw new NotFindVehicleByRegistrationException();
        }
        return getVehicleDto(vehicle);
    }

    private static VehicleDto getVehicleDto(Vehicle vehicle) {
        return new VehicleDto(
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getManuFacturingDate(),
                vehicle.getNumberOfKilometers(),
                vehicle.getDoors(),
                vehicle.getPrice(),
                vehicle.getCurrency(),
                vehicle.getCountOfOwners()
        );
    }

    private boolean validPrices(String since, String to) throws InvalidPricesException {
        try {
            return Integer.parseInt(since) < Integer.parseInt(to);
        } catch (Exception ex) {
            throw new InvalidPricesException();
        }
    }

    private boolean validDates(String since, String to) throws InvalidDatesException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateSince = format.parse(since);
            Date dateTo = format.parse(to);
            return dateTo.after(dateSince);
        } catch (ParseException e) {
            throw new InvalidDatesException();
        }

    }

    private static List<VehicleDto> getVehicleDtos(List<Vehicle> vehicles) {
        return vehicles.stream()
                .map(vehicle -> new VehicleDto(
                        vehicle.getBrand(),
                        vehicle.getModel(),
                        vehicle.getManuFacturingDate(),
                        vehicle.getNumberOfKilometers(),
                        vehicle.getDoors(),
                        vehicle.getPrice(),
                        vehicle.getCurrency(),
                        vehicle.getCountOfOwners()
                )).toList();
    }
}
