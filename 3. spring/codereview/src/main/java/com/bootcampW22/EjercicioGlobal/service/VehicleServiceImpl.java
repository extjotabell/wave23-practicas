package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.AverageSpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.InexistentBrandException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AverageSpeedDto getAverageSpeedByBrand(String brand) {
        List<Vehicle> vehicleListByBrand = vehicleRepository.findByBrand(brand);

        // max_speed is a String, so we need to convert it to double
        double averageSpeed = vehicleListByBrand.stream()
            .mapToDouble(v -> Double.parseDouble(v.getMax_speed()))
            .average()
            .orElse(-1);

        // Check if averageSpeed is valid
        if(averageSpeed == -1) {
            throw new InexistentBrandException(
                "No se encontró ningún auto de la marca " + brand + " en el sistema"
            );
        }

        // Parse double to String with 2 decimals and add "kmph" at the end
        return new AverageSpeedDto(
            String.format("%.2f", averageSpeed) + " kmph"
        );
    }
}
