package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequest;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.exception.ResourceConflictException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.utils.VehicleUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    public VehicleDto addVehicle(VehicleDto vehicleDto) {
        ObjectMapper mapper = new ObjectMapper();
        Vehicle vehicle = mapper.convertValue(vehicleDto, Vehicle.class);

        VehicleDto vehicleSearch = searchVehicle(vehicle.getId());
        if(vehicleSearch != null){
            throw new ResourceConflictException("Identificador del vehículo ya existente.");
        }
        if(!VehicleUtils.isValidVehicle(vehicle)){
            throw new BadRequest("Datos del vehículo mal formados o incompletos.");
        }

        vehicleRepository.addVehicle(vehicle);

        return vehicleDto;
    }

    @Override
    public VehicleDto searchVehicle(Long id) {
        ObjectMapper mapper = new ObjectMapper();
        Vehicle vehicle = vehicleRepository.searchVehicle(id);

        return mapper.convertValue(vehicle, VehicleDto.class);
    }

    @Override
    public List<VehicleDto> searchVehiclesColorYear(String color, int year) {
        List<Vehicle> listVehicle = vehicleRepository.searchVehiclesColorYear(color, year);
        if(listVehicle.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        ObjectMapper mapper = new ObjectMapper();
        return listVehicle.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> searchVehicleBrandBetweenYears(String brand, int start_year, int end_year) {
        List<Vehicle> listVehicle = vehicleRepository.searchVehicleBrandBetweenYears(brand, start_year, end_year);
        if(listVehicle.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        ObjectMapper mapper = new ObjectMapper();
        return listVehicle.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Double averageSpeedBrand(String brand) {
        Double response = vehicleRepository.averageSpeedBrand(brand);

        if(response == 0){
            throw new NotFoundException("No se encontraron vehículos de esa marca.");
        }

        return response;
    }

    @Override
    public List<VehicleDto> saveVehicles(List<VehicleDto> listVehicles) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> listVehicle = new ArrayList<>();

        listVehicles.forEach(vehicleDto -> {
                Vehicle vehicle = mapper.convertValue(vehicleDto, Vehicle.class);

                VehicleDto vehicleSearch = searchVehicle(vehicle.getId());
                if (vehicleSearch != null) {
                    throw new ResourceConflictException("Algún vehículo tiene un identificador ya existente.");
                }
                if (!VehicleUtils.isValidVehicle(vehicle)) {
                    throw new BadRequest("Datos de algún vehículo mal formados o incompletos.");
                }
                listVehicle.add(vehicle);
            }
        );

        vehicleRepository.saveVehicles(listVehicle);

        return listVehicles;
    }

    @Override
    public Boolean updateSpeed(int id, int speed) {
        if(speed < 0 || speed > 500){
            throw new BadRequest("Velocidad mal formada o fuera de rango.");
        }
        VehicleDto vehicleSearch = searchVehicle(Long.parseLong(id+""));

        if (vehicleSearch == null) {
            throw new ResourceConflictException("No se encontró el vehículo.");
        }
        vehicleRepository.updateSpeed(id, speed);
        return true;
    }

    @Override
    public List<VehicleDto> fuelType(String fuelType) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicles = vehicleRepository.fuelType(fuelType);

        if(vehicles.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con ese tipo de combustible.");
        }

        return vehicles.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteVehicle(int id) {
        VehicleDto vehicleSearch = searchVehicle(Long.parseLong(id+""));

        if (vehicleSearch == null) {
            throw new ResourceConflictException("No se encontró el vehículo.");
        }

        vehicleRepository.deleteVehicle(id);

        return true;
    }

    @Override
    public List<VehicleDto> transmissionType(String transmissionType) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicles = vehicleRepository.transmissionType(transmissionType);

        if(vehicles.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con ese tipo de transmisión.");
        }

        return vehicles.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean updateFuel(int id, String fuel) {
        if(fuel == null || fuel.isEmpty()){
            throw new BadRequest("Tipo de combustible mal formado o no admitido.");
        }
        VehicleDto vehicleSearch = searchVehicle(Long.parseLong(id+""));

        if (vehicleSearch == null) {
            throw new ResourceConflictException("No se encontró el vehículo.");
        }
        vehicleRepository.updateFuel(id, fuel);
        return true;
    }

    @Override
    public Double averageCapacityBrand(String brand) {
        Double response = vehicleRepository.averageCapacityBrand(brand);

        if(response == 0){
            throw new NotFoundException("No se encontraron vehículos de esa marca.");
        }

        return response;
    }

    @Override
    public List<VehicleDto> searchVehicleBrandBetweenYears(Double min_length, Double max_length, Double min_width, Double max_width) {
        return null;
    }
}
