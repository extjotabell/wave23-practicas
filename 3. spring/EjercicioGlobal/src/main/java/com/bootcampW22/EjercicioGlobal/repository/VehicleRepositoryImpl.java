package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public Vehicle saveVehicle(Vehicle vehicle) {
        listOfVehicles.add(vehicle);
        return vehicle;
    }

    @Override
    public List<Vehicle> getAllByColorAndYear(String color, int year) {
        List<Vehicle> result = listOfVehicles.stream()
                .filter(vehicle -> {
                    String colorVehicle = vehicle.getColor();
                    int yearVehicle = vehicle.getYear();
                    return colorVehicle.equalsIgnoreCase(color) && yearVehicle == year;
                })
                .collect(Collectors.toList());

        return result;
    }

    @Override
    public List<Vehicle> getAllByBrandAndYear(String brand, int start_year, int end_year) {
        List<Vehicle> result = listOfVehicles.stream()
                .filter(vehicle -> {
                    int yearVehicle = vehicle.getYear();
                    String brandVehicle = vehicle.getBrand();
                    return brandVehicle.equalsIgnoreCase(brand) && (yearVehicle >= start_year && yearVehicle <= end_year);
                })
                .collect(Collectors.toList());

        return result;
    }

    @Override
    public double getMaxSpeedAverageByBrand(String brand) {
        double speedAVG=0.0;
        int contador =0;
        List<Vehicle> vehiclesByBrand = listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());

        for(Vehicle v : vehiclesByBrand){
            contador++;
            speedAVG += v.getMax_speed();
            speedAVG = speedAVG/contador;
        }

        return speedAVG;
    }

    @Override
    public Vehicle updateSpeed(long id, double speed) {
        if(speed <= 0 || speed >= 300){
            throw new BadRequestException("Velocidad mal formada o fuera de rango");
        }

        for(Vehicle v : listOfVehicles){
            if(v.getId() == id){
                v.setMax_speed(speed);
                return v;
            }else{
                throw new NotFoundException("No se encontro el vehiculo de id: "+id);
            }
        }
        return null;
    }

    @Override
    public List<Vehicle> getAllByFuelType(String type) {
        List<Vehicle> result = listOfVehicles.stream()
                .filter(vehicle -> {
                    String fuelType = vehicle.getFuel_type();
                    return fuelType.equalsIgnoreCase(type);
                })
                .collect(Collectors.toList());

        return result;
    }

    @Override
    public Boolean delete(long id) {
        listOfVehicles.remove(id);
        return true;
    }

    @Override
    public int getCapacityByBrand(String brand) {
        int capacity=0;
        List<Vehicle> vehiclesByBrand = findByBrand(brand);

        for(Vehicle v : vehiclesByBrand){

            capacity += v.getPassengers();
        }

        return capacity/vehiclesByBrand.size();
    }

    @Override
    public List<Vehicle> getByDimensions(double length, double width) {
        List<Vehicle> result = listOfVehicles.stream()
                .filter(vehicle -> {
                    double heightVehicle = vehicle.getHeight();
                    double widthVehicle = vehicle.getWidth();
                    return heightVehicle == length && widthVehicle == width;
                })
                .collect(Collectors.toList());

        return result;
    }

    @Override
    public List<Vehicle> getByTransmission(String type) {
        List<Vehicle> response = listOfVehicles.stream()
                .filter(vehicle -> {
                    String transmissionType = vehicle.getTransmission();
                    return transmissionType.equalsIgnoreCase(type);
                })
                .collect(Collectors.toList());
        return response;
    }

    @Override
    public Vehicle updateFuel(long id, String fuel) {
        for(Vehicle v : listOfVehicles){
            if(id == v.getId()){
                v.setFuel_type(fuel);
                return v;
            }
        }
        return null;
    }

    @Override
    public List<Vehicle> getAllByWeight(double weight_min, double weight_max) {
        List<Vehicle> response = listOfVehicles.stream().filter(vehicle -> {
                double weight = vehicle.getWeight();
                return weight >= weight_min && weight <= weight_max;
        }).collect(Collectors.toList());

        return response;
    }

    @Override
    public List<Vehicle> saveAll(List<Vehicle> vehicleList) {
        for(Vehicle vehicle : vehicleList){
            listOfVehicles.add(vehicle);
        }
        return listOfVehicles;
    }
    @Override
    public List<Vehicle> findByBrand(String brand){
        List<Vehicle> vehicleList = listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
        return vehicleList;
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
