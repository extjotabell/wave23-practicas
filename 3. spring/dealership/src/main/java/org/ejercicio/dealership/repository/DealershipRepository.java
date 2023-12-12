package org.ejercicio.dealership.repository;


import org.ejercicio.dealership.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class DealershipRepository implements IDealershipRepository {

    List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public void addVehicule(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return this.vehicles.stream()
                .filter(vehicle -> Integer.parseInt(vehicle.getNumberOfKilometers()) > 0)
                .toList();
    }

    @Override
    public List<Vehicle> findVehiclesAccordingToDate(String since, String to) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateSince = format.parse(since);
            Date dateTo = format.parse(to);

            return this.vehicles.stream()
                    .filter(vehicle -> {
                        try {
                            Date dateManuFacturing = format.parse(vehicle.getManuFacturingDate());
                            return dateManuFacturing.after(dateSince) && dateManuFacturing.before(dateTo);
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .toList();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Vehicle> findVehiclesAccordingToPrice(String since, String to) {
        Integer priceSince = Integer.parseInt(since);
        Integer priceTo = Integer.parseInt(to);
        return this.vehicles.stream()
                .filter(vehicle -> {
                    return Integer.parseInt(vehicle.getPrice()) >= priceSince && Integer.parseInt(vehicle.getPrice()) <= priceTo;
                }).toList();
    }

    @Override
    public Vehicle findVehicleByRegistration(String registration) {
        return this.vehicles.stream()
                .filter(vehicle -> vehicle.getRegistration().equalsIgnoreCase(registration))
                .findFirst()
                .orElse(null);
    }
}
