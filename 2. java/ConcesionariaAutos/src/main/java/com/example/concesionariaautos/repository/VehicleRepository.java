package com.example.concesionariaautos.repository;

import com.example.concesionariaautos.entity.Vehicle;
import com.example.concesionariaautos.exception.VehicleDuplicate;
import com.example.concesionariaautos.exception.VehicleNotFound;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {
    private final List<Vehicle> vehicles;

    public VehicleRepository() {
        vehicles= new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle){
        //Si no existe un vehiculo con el mismo ID se agrega
        if(vehicles.stream().filter(v-> vehicle.getId()==v.getId()).findFirst().orElse(null)==null){
            vehicles.add(vehicle);
            return;
        }
        throw new VehicleDuplicate(vehicle.getId());
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public Vehicle findVehicleById(int id) {
        return vehicles.stream().filter(vehicle -> vehicle.getId()==id).findFirst().orElseThrow(()->new VehicleNotFound(id));
    }
}
