package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Optional<Vehicle> find(Long id) {
        return listOfVehicles.stream().filter(vehicle -> vehicle.getId().equals(id)).findFirst();
    }

    @Override
    public void create(Vehicle vehicle) {
        listOfVehicles.add(vehicle);
    }

    @Override
    public List<Vehicle> findByColorAndYear(String color, int year) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getColor().equalsIgnoreCase(color) && vehicle.getYear() == year).toList();
    }

    @Override
    public List<Vehicle> findByBrandAndYearRange(String brand, int startYear, int endYear) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand) &&
                        vehicle.getYear() >= startYear && vehicle.getYear() <= endYear).toList();
    }

    @Override
    public Double getAverageSpeedByBrand(String brand) {
        return listOfVehicles.stream()
                .mapToDouble(vehicle -> Double.parseDouble(vehicle.getMax_speed())).average().orElse(Double.NaN);
    }

    @Override
    public boolean anyMatchBrand(String brand) {
        return listOfVehicles.stream().anyMatch(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand));
    }

    @Override
    public void createBatch(List<Vehicle> vehicles) {
        listOfVehicles.addAll(vehicles);
    }

    @Override
    public void updateMaxSpeed(Long id, String maxSpeed) {
        listOfVehicles.stream()
                .filter(vehicle -> vehicle.getId().equals(id)).findFirst()
                .ifPresent(vehicle -> vehicle.setMax_speed(maxSpeed));
    }

    @Override
    public List<Vehicle> findByFuelType(String fuelType) {
        return listOfVehicles.stream().filter(vehicle -> vehicle.getFuel_type().equalsIgnoreCase(fuelType)).toList();
    }

    @Override
    public boolean anyMatchFuelType(String fuelType) {
        return listOfVehicles.stream().anyMatch(vehicle -> vehicle.getFuel_type().equalsIgnoreCase(fuelType));
    }

    @Override
    public void delete(Long id) {
        listOfVehicles.removeIf(vehicle -> vehicle.getId().equals(id));
    }

    @Override
    public boolean anyMatchTransmission(String transmission) {
        return listOfVehicles.stream().anyMatch(vehicle -> vehicle.getTransmission().equalsIgnoreCase(transmission));
    }

    @Override
    public List<Vehicle> findByTransmission(String transmission) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getTransmission().equalsIgnoreCase(transmission)).toList();
    }

    @Override
    public void updateFuelType(Long id, String fuelType) {
        listOfVehicles.stream()
                .filter(vehicle -> vehicle.getId().equals(id)).findFirst()
                .ifPresent(vehicle -> vehicle.setFuel_type(fuelType));
    }

    @Override
    public Double getAverageCapacityByBrand(String brand) {
        return listOfVehicles.stream()
                .mapToInt(Vehicle::getPassengers).average().orElse(Double.NaN);
    }

    @Override
    public List<Vehicle> findByDimensions(double minHeight, double maxHeight, double minWidth, double maxWidth) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getHeight() >= minHeight && vehicle.getHeight() <= maxHeight
                        && vehicle.getWidth() >= minHeight && vehicle.getWidth() <= maxWidth).toList();
    }

    @Override
    public List<Vehicle> findByWeightRange(double minWeight, double maxWeight) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getWeight() >= minWeight && vehicle.getWeight() <= maxWeight).toList();
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
