package org.ejercicio.surehql.util;

import org.ejercicio.surehql.model.dto.VehicleDTO;
import org.ejercicio.surehql.model.entity.Vehicle;

public class VehicleMapper {
    public static VehicleDTO vehicleMap(Vehicle vehicle) {
        return new VehicleDTO(vehicle.getId(), vehicle.getPatent(), vehicle.getBrand(), vehicle.getModel(), vehicle.getYearOfProduction(), vehicle.getWheels());
    }
}
