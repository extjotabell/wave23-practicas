package com.bootcampW22.EjercicioGlobal.utils;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

public class VehicleMapper {
    public static Vehicle mapToEntity(VehicleDto vehicleDto) {
        return new Vehicle(vehicleDto.getId(), vehicleDto.getBrand(), vehicleDto.getModel(),
                vehicleDto.getRegistration(), vehicleDto.getColor(), vehicleDto.getYear(), vehicleDto.getMax_speed(),
                vehicleDto.getPassengers(), vehicleDto.getFuel_type(), vehicleDto.getTransmission(),
                vehicleDto.getHeight(), vehicleDto.getWidth(), vehicleDto.getWeight());
    }

    public static VehicleDto mapToDTO(Vehicle vehicle) {
        return new VehicleDto(vehicle.getId(), vehicle.getBrand(), vehicle.getModel(),
                vehicle.getRegistration(), vehicle.getColor(), vehicle.getYear(), vehicle.getMax_speed(),
                vehicle.getPassengers(), vehicle.getFuel_type(), vehicle.getTransmission(),
                vehicle.getHeight(), vehicle.getWidth(), vehicle.getWeight());
    }
}
