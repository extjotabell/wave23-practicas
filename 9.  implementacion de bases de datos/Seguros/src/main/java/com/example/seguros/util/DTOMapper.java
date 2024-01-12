package com.example.seguros.util;

import com.example.seguros.dto.AccidentRequestDTO;
import com.example.seguros.dto.AccidentResponseDTO;
import com.example.seguros.dto.VehicleRequestDTO;
import com.example.seguros.dto.VehicleResponseDTO;
import com.example.seguros.model.Accident;
import com.example.seguros.model.Vehicle;

public class DTOMapper {
    public static Vehicle mapToVehicle(VehicleRequestDTO vehicleRequestDTO) {
        return new Vehicle(vehicleRequestDTO.getPatent(), vehicleRequestDTO.getBrand(), vehicleRequestDTO.getModel(),
                vehicleRequestDTO.getYearOfFabrication(), vehicleRequestDTO.getWheels());
    }

    public static VehicleResponseDTO mapToVehicleResponseDTO(Vehicle vehicle) {
        return new VehicleResponseDTO(vehicle.getId(), vehicle.getPatent(), vehicle.getBrand(), vehicle.getModel(),
                vehicle.getYearOfFabrication(), vehicle.getWheels());
    }

    public static Accident mapToAccident(AccidentRequestDTO accidentRequestDTO, Vehicle vehicle) {
        return new Accident(accidentRequestDTO.getDate(), accidentRequestDTO.getCost(), vehicle);
    }

    public static AccidentResponseDTO mapToAccidentResponseDTO(Accident accident) {
        return new AccidentResponseDTO(accident.getId(), accident.getDate(), accident.getCost(),
                mapToVehicleResponseDTO(accident.getVehicle()));
    }
}
