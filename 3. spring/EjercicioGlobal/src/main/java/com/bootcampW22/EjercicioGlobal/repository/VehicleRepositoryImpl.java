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

    // BUSCAR ID
    @Override
    public Vehicle buscarId(Long id) {
        for (Vehicle vehicle : listOfVehicles){
            if (vehicle.getId().equals(id)){
                return vehicle;
            }
        }
        return null;
    }

    // EJERCICIO 1
    @Override
    public void agregarVehiculo(Vehicle vehicle) {
        listOfVehicles.add(vehicle);
    }

    @Override
    public Boolean existeId(Long id) {
        for (Vehicle vehicle : listOfVehicles){
            if (vehicle.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean formatoValido(Vehicle vehicle) {
        return vehicle.getFuel_type() == null || vehicle.getFuel_type().isEmpty();
    }

    // EJERCICIO 2
    @Override
    public List<Vehicle> buscarColoryear(String color, Integer year) {
        List<Vehicle> vehiclesOk = new ArrayList<>();
        for (Vehicle vehicle: listOfVehicles){
            if(vehicle.getColor().equals(color)  && vehicle.getYear() == year){
                vehiclesOk.add(vehicle);
            }
        }
        return vehiclesOk;
    }

    // EJERCICIO 3
    @Override
    public List<Vehicle> buscarMarcaYears(String brand, Integer start_year, Integer end_year) {
        List<Vehicle> vehiclesOK = new ArrayList<>();
        for (Vehicle vehicle : listOfVehicles){
            if (vehicle.getBrand().equals(brand) && vehicle.getYear() >= start_year && vehicle.getYear() <= end_year) {
                vehiclesOK.add(vehicle);
            }
        }
        return vehiclesOK;
    }

    //EJERCICIO 4
    @Override
    public double buscarVelocidadPromMarca(String brand) {
        List<Vehicle> listavehicleOk = new ArrayList<>();
        int velocidadAcumulada = 0;
        double velocidadPromedio = 0.0;

        for (Vehicle vehicle: listOfVehicles){
            if (vehicle.getBrand().equals(brand)){
                velocidadAcumulada += Integer.parseInt(vehicle.getMax_speed());
                listavehicleOk.add(vehicle);
            }
        }
        if (!listavehicleOk.isEmpty()){
            velocidadPromedio = (double) velocidadAcumulada / listavehicleOk.size();
        }
        return velocidadPromedio;
    }

    // EJERCICIO 6
    @Override
    public void updateVelocidadxTipo(Vehicle vehicle) {
        listOfVehicles.removeIf(v-> Objects.equals(v.getId(), vehicle.getId()));
        listOfVehicles.add(vehicle);
    }

    // EJERCICIO 7
    @Override
    public List<Vehicle> buscarMarcaYear(String type) {
        List<Vehicle> listaOK = new ArrayList<>();

        for (Vehicle vehicle: listOfVehicles){
            if (vehicle.getFuel_type().equals(type)) {
                listaOK.add(vehicle);
            }
        }
        return listaOK;
    }

    // EJERCICIO 8
    @Override
    public void eliminarVehiculoId(Long id) {
        listOfVehicles.removeIf(vehicle -> vehicle.getId().equals(id));
    }

    //EJERCICIO 9
    @Override
    public List<Vehicle> buscarTransmision(String type) {
        List<Vehicle> vehiclesOk = new ArrayList<>();

        for (Vehicle vehicle: listOfVehicles){
            if (vehicle.getTransmission().equals(type)){
                vehiclesOk.add(vehicle);
            }
        }
        return vehiclesOk;
    }

    // EJERCICIO 10
    @Override
    public void actualizarTipoCombustible(Vehicle vehicle) {
        listOfVehicles.removeIf(v-> Objects.equals(v.getId(), vehicle.getId()));
        listOfVehicles.add(vehicle);
    }

    // EJERCICIO 11
    @Override
    public List<Vehicle> capacidadPromedioMarca(String brand) {
        List<Vehicle> vehiclesOk = new ArrayList<>();
        for (Vehicle vehicle: listOfVehicles){
            vehicle.getBrand().equals(brand);
            vehiclesOk.add(vehicle);
        }
        return vehiclesOk;
    }

    // EJERCICIO 12
    @Override
    public List<Vehicle> buscarDimensiones(Double min_width, Double max_width, Double min_height, Double max_height) {
        return this.listOfVehicles.stream()
                .filter(v -> min_width <= v.getWidth() && v.getWidth()<= max_width)
                .filter(v -> min_height <= v.getHeight() && v.getHeight() <= max_height)
                .toList();
    }

    // EJECICIO 13
    @Override
    public List<Vehicle> buscarRangoPeso(Double weight_min, Double weight_max) {
        return this.listOfVehicles.stream()
                .filter(v -> weight_min <= v.getWidth() && v.getWidth()<= weight_max)
                .toList();
    }


    // BASEE
    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        listOfVehicles = vehicles;
    }
}
