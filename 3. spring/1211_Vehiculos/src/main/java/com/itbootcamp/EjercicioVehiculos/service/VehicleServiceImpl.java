package com.itbootcamp.EjercicioVehiculos.service;

import com.itbootcamp.EjercicioVehiculos.dto.MessageDto;
import com.itbootcamp.EjercicioVehiculos.dto.VehicleDto;
import com.itbootcamp.EjercicioVehiculos.dto.request.VehicleRequestDto;
import com.itbootcamp.EjercicioVehiculos.dto.response.VehicleWithoutServicesResponseDto;
import com.itbootcamp.EjercicioVehiculos.entity.Vehicle;
import com.itbootcamp.EjercicioVehiculos.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService{

    @Autowired
    IVehicleRepository vehicleRepository;

    @Override
    public MessageDto save(VehicleRequestDto vehicleRequestDto) {
        Vehicle vehicle = new Vehicle(
                Vehicle.getNewId(),
                vehicleRequestDto.getBrand(),
                vehicleRequestDto.getModel(),
                vehicleRequestDto.getManufacturingDate(),
                vehicleRequestDto.getNumberOfKilometers(),
                vehicleRequestDto.getDoors(),
                vehicleRequestDto.getPrice(),
                vehicleRequestDto.getCurrency(),
                vehicleRequestDto.getServicesList(),
                vehicleRequestDto.getCountOfOwners());

        vehicleRepository.save(vehicle);

        return new MessageDto("Vehicle created!");
    }

    @Override
    public List<VehicleWithoutServicesResponseDto> findAll() {

        List<VehicleWithoutServicesResponseDto> vehicleListDto = new ArrayList<>();

        List<Vehicle> vehiclesList = vehicleRepository.findAll();
        vehiclesList.forEach(v -> vehicleListDto.add(new VehicleWithoutServicesResponseDto(
                v.getId(),
                v.getBrand(),
                v.getModel(),
                v.getManufacturingDate(),
                v.getNumberOfKilometers(),
                v.getDoors(),
                v.getPrice(),
                v.getCurrency(),
                v.getCountOfOwners()
        )));

        return vehicleListDto;
    }

    @Override
    public VehicleDto findById(int id) {
        Vehicle vehicle = vehicleRepository.findById(id);
        if(vehicle != null){
            return new VehicleDto(
                    vehicle.getId(),
                    vehicle.getBrand(),
                    vehicle.getModel(),
                    vehicle.getManufacturingDate(),
                    vehicle.getNumberOfKilometers(),
                    vehicle.getDoors(),
                    vehicle.getPrice(),
                    vehicle.getCurrency(),
                    vehicle.getServicesList(),
                    vehicle.getCountOfOwners()
            );
        }
        return null;
    }

    @Override
    public List<VehicleWithoutServicesResponseDto> findDatesRange(String since, String to) {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        List<Vehicle> filteredVehicles = new ArrayList<>();
        vehicleList.forEach(v -> {
            LocalDate startDate = LocalDate.parse(since);
            LocalDate endDate = LocalDate.parse(to);
            LocalDate vehicleDate = LocalDate.parse(v.getManufacturingDate());
            if((vehicleDate.isEqual(startDate) || vehicleDate.isAfter(startDate))
                    && (vehicleDate.isEqual(endDate) || vehicleDate.isBefore(endDate))){
                filteredVehicles.add(v);
            }
        });

        List<VehicleWithoutServicesResponseDto> vehicleListDto = new ArrayList<>();
        filteredVehicles.forEach(v -> vehicleListDto.add(new VehicleWithoutServicesResponseDto(
                v.getId(),
                v.getBrand(),
                v.getModel(),
                v.getManufacturingDate(),
                v.getNumberOfKilometers(),
                v.getDoors(),
                v.getPrice(),
                v.getCurrency(),
                v.getCountOfOwners()
        )));
        return vehicleListDto;
    }

    @Override
    public List<VehicleWithoutServicesResponseDto> findByPriceRange(int since, int to) {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        List<Vehicle> filteredVehicles = new ArrayList<>();
        vehicleList.forEach(v -> {
            if(Integer.parseInt(v.getPrice()) >= since && Integer.parseInt(v.getPrice()) <= to){
                filteredVehicles.add(v);
            }
        });

        List<VehicleWithoutServicesResponseDto> vehicleListDto = new ArrayList<>();
        filteredVehicles.forEach(v -> vehicleListDto.add(new VehicleWithoutServicesResponseDto(
                v.getId(),
                v.getBrand(),
                v.getModel(),
                v.getManufacturingDate(),
                v.getNumberOfKilometers(),
                v.getDoors(),
                v.getPrice(),
                v.getCurrency(),
                v.getCountOfOwners()
        )));
        return vehicleListDto;
    }
}
