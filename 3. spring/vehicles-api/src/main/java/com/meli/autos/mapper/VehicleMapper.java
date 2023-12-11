package com.meli.autos.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.autos.dto.request.VehicleEntryDTO;
import com.meli.autos.dto.response.VehicleDTO;
import com.meli.autos.entity.Service;
import com.meli.autos.entity.Vehicle;
import org.apache.catalina.Server;

import java.time.LocalDate;

public class VehicleMapper {

    public static Vehicle vehicleDTOToVehicle(VehicleDTO vehicleDTO){
        return VehicleMapper.extractData(vehicleDTO);
    }

    public static Vehicle vehicleEntryDTOToVehicle(VehicleEntryDTO vehicleEntryDTO){
        Vehicle vehicle = VehicleMapper.extractData(vehicleEntryDTO);
        vehicle.setServices(vehicleEntryDTO.getServices().stream()
                                                    .map(s -> new ObjectMapper().convertValue(s, Service.class))
                                                    .toList());
        return vehicle;
    }

    public static VehicleDTO vehicleToVehicleDTO(Vehicle vehicle){
        return VehicleMapper.extractDataDTO(vehicle);
    }

    private static Vehicle extractData(VehicleDTO vehicleDTO){
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setManufacturingDate(LocalDate.parse(vehicleDTO.getManufacturingDate()));
        vehicle.setNumberOfKilometers(vehicleDTO.getNumberOfKilometers());
        vehicle.setDoors(vehicleDTO.getDoors());
        vehicle.setPrice(vehicleDTO.getPrice());
        vehicle.setCurrency(vehicleDTO.getCurrency());
        vehicle.setCountOfOwners(vehicleDTO.getCountOfOwners());
        return vehicle;
    }
    private static VehicleDTO extractDataDTO(Vehicle vehicle){
        VehicleDTO vehicleDTO = new VehicleDTO(vehicle.getBrand(), vehicle.getModel(), vehicle.getManufacturingDate().toString(),
                                                vehicle.getNumberOfKilometers(), vehicle.getDoors(), vehicle.getPrice(),
                                                vehicle.getCurrency(), vehicle.getCountOfOwners());
        return vehicleDTO;
    }

}
