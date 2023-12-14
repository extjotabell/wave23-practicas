package com.bootcampW22.EjercicioGlobal.utils;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Mapper {
    private static ObjectMapper mapper = new ObjectMapper();
    public static List<VehicleDto> mapVehiclesToVehiclesDto(List<Vehicle> vehicles) {
        List<VehicleDto> encontrados = vehicles.stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .toList();
        return encontrados;
    }

    public static Vehicle mapFromVehicleToVehicleDTO(VehicleDto vehicleDto) {
        Vehicle vehicle = mapper.convertValue(vehicleDto, Vehicle.class);
        return vehicle;
    }
}
