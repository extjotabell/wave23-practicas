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
import java.util.OptionalDouble;

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
    public Vehicle findById(Long id) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean addVehicle(Vehicle vehicle) {
        return listOfVehicles.add(vehicle);
    }

    @Override
    public List<Vehicle> findByColorAndYear(String color, int year) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getColor().equalsIgnoreCase(color) && vehicle.getYear() == year)
                .toList();
    }

    @Override
    public List<Vehicle> findByBrandAndYears(String brand, int start_year, int end_year) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand) && vehicle.getYear() >= start_year && vehicle.getYear() <= end_year)
                .toList();
    }

    @Override
    public OptionalDouble getSpeedAverageByBrand(String brand) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .mapToDouble(Vehicle::parsearVelocidad)
                .average();
    }

    @Override
    public void updateSpeed(Long id, String max_speed) {
        findById(id).setMax_speed(max_speed);
    }

    @Override
    public List<Vehicle> getVehiclesByDimensions(double minLenght, double maxLenght, double minWidth, double maxWidth) {
         return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getHeight()>= minLenght && vehicle.getHeight() <= maxLenght && vehicle.getWidth()>= minWidth && vehicle.getWidth()<=maxWidth)
                .toList();
    }

    @Override
    public OptionalDouble getCapacityAverageByBrand(String brand) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .mapToDouble(Vehicle::getPassengers)
                .average();
    }

    @Override
    public void updateFuel(Long id, String fuel) {
        findById(id).setFuel_type(fuel);
    }

    @Override
    public List<Vehicle> getVehiclesByWeight(double min, double max) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getWeight() >= min && vehicle.getWeight() <= max)
                .toList();
    }

    @Override
    public void deleteVehicle(Long id) {
        listOfVehicles.remove(findById(id));
    }

    @Override
    public List<Vehicle> getByFuelType(String type) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getFuel_type().equalsIgnoreCase(type))
                .toList();
    }

    @Override
    public List<Vehicle> getByTransmissionType(String type) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getTransmission().equalsIgnoreCase(type))
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
