package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    private List<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl() throws IOException {
        loadDataBase();
    }
    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        listOfVehicles.add(vehicle);
    }

    @Override
    public Vehicle searchVehicle(Long id) {
        return listOfVehicles.stream().filter(x -> Objects.equals(x.getId(), id)).findFirst().orElse(null);
    }

    @Override
    public List<Vehicle> searchVehiclesColorYear(String color, int year) {
        return listOfVehicles.stream().filter(x -> x.getColor().equals(color))
                .filter(x -> x.getYear() == year).toList();
    }

    @Override
    public List<Vehicle> searchVehicleBrandBetweenYears(String brand, int start_year, int end_year) {
        return listOfVehicles.stream().filter(x ->  x.getBrand().equals(brand))
                .filter(x -> x.getYear() >= start_year && x.getYear() <= end_year).toList();
    }

    @Override
    public Double averageSpeedBrand(String brand) {
        return listOfVehicles.stream().filter(x -> x.getBrand().equals(brand))
                .mapToDouble(x -> Double.parseDouble(x.getMax_speed()))
                .average().orElse(0);
    }

    @Override
    public Boolean saveVehicles(List<Vehicle> listVehicles) {
        listOfVehicles.addAll(listVehicles);

        return true;
    }

    @Override
    public Boolean updateSpeed(int id, int speed) {
        for (Vehicle vehicle : listOfVehicles) {
            if (vehicle.getId() == id) {
                vehicle.setMax_speed(speed+"");
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Vehicle> fuelType(String fuelType) {
        return listOfVehicles.stream().filter(x -> x.getFuel_type().equals(fuelType))
                .toList();
    }

    @Override
    public Boolean deleteVehicle(int id) {
        listOfVehicles.removeIf(vehicle -> vehicle.getId() == id);

        return true;
    }

    @Override
    public List<Vehicle> transmissionType(String transmissionType) {
        return listOfVehicles.stream().filter(x -> x.getTransmission().equals(transmissionType))
                .toList();
    }

    @Override
    public Boolean updateFuel(int id, String fuel) {
        for (Vehicle vehicle : listOfVehicles) {
            if (vehicle.getId() == id) {
                vehicle.setFuel_type(fuel);
                return true;
            }
        }
        return false;
    }

    @Override
    public Double averageCapacityBrand(String brand) {
        return listOfVehicles.stream().filter(x -> x.getBrand().equals(brand))
                .mapToDouble(Vehicle::getPassengers)
                .average().orElse(0);
    }

    @Override
    public List<Vehicle> searchVehicleBrandBetweenYears(Double min_length, Double max_length, Double min_width, Double max_width) {
        return listOfVehicles.stream()
                .filter(x -> x.getHeight() >= min_length && x.getHeight() <= max_length)
                .filter(x -> x.getWidth() >= min_width && x.getWidth() <= max_width)
                .toList();
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        listOfVehicles = vehicles;
    }
}
