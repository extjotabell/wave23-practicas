package com.meli.SeguroAutos.util.mapper;

import com.meli.SeguroAutos.dto.VehicleRequestDTO;
import com.meli.SeguroAutos.entity.Vehicle;

public class VehicleMapper {

    public static Vehicle mapToVehicle(VehicleRequestDTO vehicleRequestDTO){
        Vehicle vehicle = new Vehicle();
        vehicle.setPatent(vehicleRequestDTO.getPatent());
        vehicle.setBrand(vehicleRequestDTO.getBrand());
        vehicle.setModel(vehicleRequestDTO.getModel());
        vehicle.setYearOfProduction(vehicleRequestDTO.getYearOfProduction());
        vehicle.setNumberOfWheels(vehicleRequestDTO.getNumberOfWheels());
        return vehicle;
    }

}
